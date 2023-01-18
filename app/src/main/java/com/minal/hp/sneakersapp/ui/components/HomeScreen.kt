package com.minal.hp.sneakersapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.minal.hp.sneakersapp.R
import com.minal.hp.sneakersapp.viewmodel.HomeScreenViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    val viewModel = viewModel<HomeScreenViewModel>()

    Column(
        modifier = modifier
    ) {
        TextDropDownComponent(
            text = R.string.popular
        )
        val sneakersState = viewModel.sneakersState.collectAsState()
        SneakersCollectionGrid(
            items = sneakersState.value.sneakersList,
        )
        if (sneakersState.value.isLoading) {
            //show Loader
        }
    }
}