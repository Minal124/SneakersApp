package com.minal.hp.sneakersapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.minal.hp.sneakersapp.model.datamodel.SneakersInfo
import com.minal.hp.sneakersapp.model.repository.ISneakersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

private val logger get() = Timber.tag("HomeScreenViewModel")

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val sneakersRepository: ISneakersRepository
) : ViewModel() {

    private val _sneakersState: MutableStateFlow<SneakersViewState> = MutableStateFlow(SneakersViewState())
    val sneakersState = _sneakersState.asStateFlow()

    init {
        _sneakersState.value = SneakersViewState(
            isLoading = true
        )
        viewModelScope.launch {
            try {
                sneakersRepository.getSneakers()
                    .flowOn(Dispatchers.IO)
                    .collect{
                    _sneakersState.value = SneakersViewState(
                        isLoading = false,
                        sneakersList = it
                    )
                }
                logger.d("fetch Sneakers Data")
            } catch (e: Exception) {
                _sneakersState.value = SneakersViewState(
                    isLoading = false,
                    errorString = "Failure in fetching Schema"
                )
                logger.e(e, "Failure in fetching Schema")
            }
        }
    }

    fun refresh() {
        viewModelScope.launch {
            try {
                sneakersRepository.fetchAndUpdateSneakers()
            } catch (e: Exception) {
                logger.e(e, "Failure in updating schema")
            }
        }
    }
}


data class SneakersViewState (
    val isLoading:Boolean = true,
    val sneakersList: List<SneakersInfo> = emptyList(),
    val errorString: String? = null
)
