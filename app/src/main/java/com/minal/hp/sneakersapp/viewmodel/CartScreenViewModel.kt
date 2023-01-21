package com.minal.hp.sneakersapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.minal.hp.sneakersapp.model.datamodel.CartItemInfo
import com.minal.hp.sneakersapp.model.repository.ISneakersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

private val logger get() = Timber.tag("CartScreenViewModel")

@HiltViewModel
class CartScreenViewModel @Inject constructor(
    private val sneakersRepository: ISneakersRepository
) : ViewModel() {

    private val _sneakersCartListState =  MutableStateFlow(CartViewState())
    val sneakersCartListState: StateFlow<CartViewState>
        get() = _sneakersCartListState.asStateFlow()

    init {
        viewModelScope.launch {
            sneakersRepository.getCartItems()
                .flowOn(Dispatchers.IO)
                .collect {
                    _sneakersCartListState.value =
                        sneakersCartListState.value.copy(
                            isLoading = false,
                            sneakersList = it
                        )
                }
        }
    }

    fun handleViewEvent(viewEvent: SneakersViewEvent) {
        viewModelScope.launch {
            when (viewEvent) {
                is SneakersViewEvent.AddItem -> {
                    sneakersRepository.saveCartItem(viewEvent.cartItemInfo)
                }
                is SneakersViewEvent.RemoveItem -> {
                   sneakersRepository.deleteCartItem(viewEvent.cartItemInfo)
                }
            }
        }
    }
}

sealed class SneakersViewEvent {
    data class AddItem(val cartItemInfo: CartItemInfo) : SneakersViewEvent()
    data class RemoveItem(val cartItemInfo: CartItemInfo) : SneakersViewEvent()
}

data class CartViewState (
    val isLoading:Boolean = true,
    val sneakersList: List<CartItemInfo> = emptyList(),
    val errorString: String? = null
)