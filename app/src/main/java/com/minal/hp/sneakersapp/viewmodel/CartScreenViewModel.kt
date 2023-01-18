package com.minal.hp.sneakersapp.viewmodel

import androidx.lifecycle.ViewModel
import com.minal.hp.sneakersapp.model.datamodel.SneakersData
import com.minal.hp.sneakersapp.model.repository.ISneakersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import timber.log.Timber
import javax.inject.Inject

private val logger get() = Timber.tag("CartScreenViewModel")

@HiltViewModel
class CartScreenViewModel @Inject constructor(
    private val sneakersRepository: ISneakersRepository
) : ViewModel() {

    private val _sneakersCartListState =  MutableStateFlow(SneakersViewState())
    val sneakersCartListState: StateFlow<SneakersViewState>
        get() = _sneakersCartListState.asStateFlow()

    fun handleViewEvent(viewEvent: SneakersViewEvent) {
        when (viewEvent) {
            is SneakersViewEvent.AddItem -> {
                val currentState = sneakersCartListState.value
                val items = currentState.sneakersList.toMutableList().apply {
                    add(viewEvent.sneakerData)
                }.toList()
                _sneakersCartListState.value = sneakersCartListState.value.copy(isLoading = false, sneakersList = items)
            }
            is SneakersViewEvent.RemoveItem -> {
                val currentState = sneakersCartListState.value
                val items = currentState.sneakersList.toMutableList().apply {
                    remove(viewEvent.sneakerData)
                }.toList()
                _sneakersCartListState.value = sneakersCartListState.value.copy(isLoading = false, sneakersList = items)
            }
        }
    }
}

sealed class SneakersViewEvent {
    data class AddItem(val sneakerData: SneakersData) : SneakersViewEvent()
    data class RemoveItem(val sneakerData: SneakersData) : SneakersViewEvent()
}