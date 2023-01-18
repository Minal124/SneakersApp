package com.minal.hp.sneakersapp.ui.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.minal.hp.sneakersapp.R
import com.minal.hp.sneakersapp.ui.theme.SneakersAppTheme

@Composable
fun AppBottomBarNavigation(
    modifier: Modifier = Modifier,
    action : (String) -> Unit = {}
) {
    BottomNavigation(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.primary
    ) {
        BottomNavigationItem(
            icon = {
                   Icon(
                       imageVector = Icons.Default.Home,
                       contentDescription = null
                   )
            },
            label = {
                Text(stringResource(R.string.home))
            },
            selected = true,
            onClick = {action("HOME")}
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.cart))
            },
            selected = false,
            onClick = {action("CART")}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AppBottomBarNavigationPreview() {
    SneakersAppTheme() {
        AppBottomBarNavigation()
    }
}