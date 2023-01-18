package com.minal.hp.sneakersapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.minal.hp.sneakersapp.R
import com.minal.hp.sneakersapp.viewmodel.CartScreenViewModel
import com.minal.hp.sneakersapp.viewmodel.SneakersViewEvent

@Composable
fun sneakersVerticalLazyComponent(
    modifier: Modifier = Modifier
) {
    val viewModel = viewModel<CartScreenViewModel>()
    val cartItemsState = viewModel.sneakersCartListState.collectAsState()
    if (cartItemsState.value.isLoading) {
        //show Loader
    }
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(18.dp),
        modifier = modifier
    ) {
        items(items = cartItemsState.value.sneakersList) { item ->
           SneakersHorizontalCard(
               modifier = Modifier,
               shoeName = item.shoe,
               price =  item.retailPrice.toString(),
               drawable = R.drawable.ic_nike_air,
               item = item,
               onRemoveItem = {
                   viewModel.handleViewEvent(SneakersViewEvent.RemoveItem(it))
               }
           )
        }
    }
}