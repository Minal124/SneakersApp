package com.minal.hp.sneakersapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import com.minal.hp.sneakersapp.R

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ViewPagerComponent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val state = rememberPagerState()
        val items: List<Int> = listOf(R.drawable.ic_nike_air,R.drawable.ic_nike_air,R.drawable.ic_nike_air)

        HorizontalPager(
            count = items.size,
            state = state
        ) { page ->
            Column {
                Image(
                    painter = painterResource(items[page]),
                    contentDescription = ""
                )
            }
        }
        HorizontalPagerIndicator(
            pagerState = state,
            modifier = Modifier.padding(top= 42.dp)
        )
    }
}