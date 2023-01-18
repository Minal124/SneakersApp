package com.minal.hp.sneakersapp.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.minal.hp.sneakersapp.R
import com.minal.hp.sneakersapp.model.datamodel.MediaData
import com.minal.hp.sneakersapp.model.datamodel.SneakersData
import com.minal.hp.sneakersapp.ui.theme.Shapes
import com.minal.hp.sneakersapp.ui.theme.SneakersAppTheme

@Composable
fun SneakersCollectionCard(
    modifier: Modifier = Modifier,
    action: () -> Unit = {},
    item: SneakersData,
    @DrawableRes drawable: Int,
    shoeName: String,
    price: String,
    addItemAction: (item: SneakersData)-> Unit = {}
) {
    Card(
        elevation = 2.dp,
        shape = Shapes.medium,
        modifier = modifier.clickable(onClick = action)
    ) {
        Box(
            modifier = Modifier
        ) {
            Image(
                imageVector = Icons.Default.AddCircle,
                colorFilter = ColorFilter.tint(color = MaterialTheme.colors.primary),
                contentDescription = null,
                modifier = Modifier.clickable { addItemAction(item) }
                    .align(Alignment.TopStart)
                    .padding(4.dp)
                    .size(20.dp)
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Box(
                modifier = Modifier
            ) {
                Canvas(modifier = Modifier.size(88.dp)) {
                    val canvasWidth = size.width
                    val canvasHeight = size.height
                    drawCircle(
                        color = Color(0xFFF7D0BF),
                        center = Offset(x = canvasWidth / 2, y = canvasHeight / 2),
                        radius = size.minDimension / 3
                    )
                }
                Image(
                    painter = painterResource(drawable),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(85.dp)
                )
            }
            Text(
                text = shoeName,
                style = MaterialTheme.typography.body2,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = price,
                modifier = Modifier,
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.primary
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun SneakersCollectionCardPreview() {
    SneakersAppTheme() {
        SneakersCollectionCard(
            drawable = R.drawable.ic_nike_air,
            shoeName = "Nike Air",
            price = "$199",
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