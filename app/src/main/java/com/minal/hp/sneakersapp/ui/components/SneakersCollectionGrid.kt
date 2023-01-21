package com.minal.hp.sneakersapp.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.minal.hp.sneakersapp.R
import com.minal.hp.sneakersapp.SneakersDetailsActivity
import com.minal.hp.sneakersapp.model.datamodel.CartItemInfo
import com.minal.hp.sneakersapp.model.datamodel.SneakersInfo
import com.minal.hp.sneakersapp.viewmodel.CartScreenViewModel
import com.minal.hp.sneakersapp.viewmodel.SneakersViewEvent

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SneakersCollectionGrid(
    modifier: Modifier = Modifier,
    items:List<SneakersInfo>
) {
    val viewModel = viewModel<CartScreenViewModel>()
    val context = LocalContext.current
    LazyVerticalGrid(
        cells = GridCells.Fixed(2) ,
        contentPadding = PaddingValues(vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        items(items = items){ item ->
            SneakersCollectionCard(
                modifier = Modifier,
                shoeName = item.shoe,
                price =  item.retailPrice.toString(),
                item = item,
                drawable = R.drawable.ic_nike_air,
                addItemAction = {
                    viewModel.handleViewEvent(SneakersViewEvent.AddItem(CartItemInfo(
                        id = it.id,
                        brand = it.brand,
                        colorway = it.colorway,
                        gender = it.gender,
                        releaseDate = it.releaseDate,
                        retailPrice = it.retailPrice,
                        styleId = it.styleId,
                        shoe = it.shoe,
                        name = it.name,
                        title = it.title,
                        year = it.year
                    )))
                },
                action = {
                    SneakersDetailsActivity.launch(
                        context = context,
                        params = SneakersDetailsActivity.Params(
                            id= item.id,
                            name = item.name,
                            price= item.retailPrice
                        )
                    )
                }
            )
        }
    }
}