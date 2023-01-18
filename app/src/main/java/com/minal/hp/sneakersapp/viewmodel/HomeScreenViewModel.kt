package com.minal.hp.sneakersapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.minal.hp.sneakersapp.model.datamodel.SneakersData
import com.minal.hp.sneakersapp.model.datamodel.toSneakersData
import com.minal.hp.sneakersapp.model.repository.ISneakersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
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
                val sneakersList = sneakersRepository.getSneakers().map { sneakersData->
                    sneakersData.toSneakersData()
                }
                _sneakersState.value = SneakersViewState(
                    isLoading = false,
                    sneakersList=sneakersList
                )
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
}


data class SneakersViewState (
    val isLoading:Boolean = true,
    val sneakersList: List<SneakersData> = emptyList(),
    val errorString: String? = null
)
