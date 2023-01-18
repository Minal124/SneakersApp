package com.minal.hp.sneakersapp.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.minal.hp.sneakersapp.R
import com.minal.hp.sneakersapp.model.datamodel.MediaData
import com.minal.hp.sneakersapp.model.datamodel.SneakersData
import com.minal.hp.sneakersapp.ui.theme.Shapes
import com.minal.hp.sneakersapp.ui.theme.SneakersAppTheme

@Composable
fun SneakersHorizontalCard(
    modifier: Modifier = Modifier,
    @DrawableRes drawable: Int,
    shoeName: String,
    price: String,
    onClick: () -> Unit = {},
    item: SneakersData ,
    onRemoveItem: (item: SneakersData) -> Unit = {}
) {
    Card(
        elevation = 2.dp,
        shape = Shapes.medium,
        modifier = modifier.clickable(onClick = onClick)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.ic_baseline_cancel_24),
                colorFilter = ColorFilter.tint(color = MaterialTheme.colors.primary),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .size(24.dp)
                    .clickable {
                        onRemoveItem(item)
                    }
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(130.dp),
                painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Inside
            )
            Column(
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Text(
                    text = shoeName,
                    style = MaterialTheme.typography.h6,
                )
                Text(
                    text = price,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SneakersHorizontalCardPreview() {
    SneakersAppTheme() {
        SneakersHorizontalCard(
            shoeName = "Nike",
            price = "$300",
            drawable = R.drawable.ic_nike_air,
            item = SneakersData(
                id = "11",
                brand = "",
                colorway = "",
                gender = "",
                media = MediaData("","",""),
                releaseDate = "",
                retailPrice = 200,
                styleId = "",
                shoe = "",
                name = "",
                title = "",
                year = 1222
            )
        )
    }
}