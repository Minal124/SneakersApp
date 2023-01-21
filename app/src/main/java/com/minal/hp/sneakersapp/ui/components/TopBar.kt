package com.minal.hp.sneakersapp.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.minal.hp.sneakersapp.ui.theme.SneakersAppTheme

@Composable
fun TopBar(
    topBarText: String,
    topBarIcon: ImageVector?= null,
    action: () -> Unit = {}
) {
    TopAppBar(
        title = {
            Text(
                text = topBarText,
                modifier = Modifier.padding(start = 4.dp)
            )
        },
        actions = {
            IconButton(
                onClick = action
            ) {
                if(topBarIcon!= null) {
                    Icon(
                        imageVector = topBarIcon ,
                        contentDescription = null,
                        tint = MaterialTheme.colors.primary
                    )
                }
            }
        },
        backgroundColor = MaterialTheme.colors.surface,
        contentColor = MaterialTheme.colors.primary
    )
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    SneakersAppTheme() {
        TopBar(
            topBarText = "SNEAKERSHIP",
            topBarIcon = Icons.Default.Search,
        )
    }
}