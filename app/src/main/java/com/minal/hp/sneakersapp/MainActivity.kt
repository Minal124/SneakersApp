package com.minal.hp.sneakersapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.minal.hp.sneakersapp.ui.components.*
import com.minal.hp.sneakersapp.ui.theme.SneakersAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SneakersApp()
        }
    }

    @Composable
    fun SneakersApp() {
        SneakersAppTheme {
            var currentSelectedSlug by remember {
                mutableStateOf("HOME")
            }
            Scaffold(
                topBar = {
                    TopBar(
                        topBarText = if(currentSelectedSlug == "HOME") {
                            stringResource(R.string.top_bar)
                        } else {
                            currentSelectedSlug
                               },
                        topBarIcon = if(currentSelectedSlug == "HOME") {
                            Icons.Default.Search
                        } else {null},
                        action = {
                        }
                    )
                },
                bottomBar = {
                    AppBottomBarNavigation(
                        action = { bottomBarItem ->
                            currentSelectedSlug =  bottomBarItem
                        }
                    )
                }
            ) {
                MainScreen(
                    modifier = Modifier.padding(
                        start = 24.dp,
                        end= 24.dp
                    ),
                    selectedBottomBarItem = currentSelectedSlug
                )
            }
        }
    }

    @Composable
    fun MainScreen(
        modifier: Modifier = Modifier,
        selectedBottomBarItem: String
    ) {
        when(selectedBottomBarItem) {
            "HOME" -> {
                HomeScreen(
                    modifier = modifier
                )
            }
            "CART" -> {
                CartScreen(
                    modifier = modifier
                )
            }
        }
    }
    
    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        SneakersAppTheme() {
            MainScreen(
                selectedBottomBarItem = "Home"
            )
        }
    }
}

