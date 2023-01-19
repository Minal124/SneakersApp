package com.minal.hp.sneakersapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.minal.hp.sneakersapp.R
import com.minal.hp.sneakersapp.ui.theme.SneakersAppTheme
import com.minal.hp.sneakersapp.viewmodel.CartScreenViewModel

@Composable
fun CartScreen(
    modifier: Modifier = Modifier
) {
    val viewModel = viewModel<CartScreenViewModel>()
    val cartItemsState = viewModel.sneakersCartListState.collectAsState()

    LazyColumn(
        modifier = modifier.padding(top = 24.dp)
            .fillMaxWidth(),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        item{
            sneakersVerticalLazyComponent()
        }
        item{
            if (cartItemsState.value.sneakersList.isNotEmpty()) {
                var subTotal = 0
                cartItemsState.value.sneakersList.forEach {
                    subTotal += it.retailPrice
                }
                var total = subTotal + 40
                Spacer(modifier = Modifier.padding(8.dp))
                Text(
                    text = stringResource(id = R.string.order_details),
                    style = MaterialTheme.typography.h6
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Text(
                    text = stringResource(id = R.string.subtotal,subTotal),
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.secondary
                )
                Text(
                    text = stringResource(id = R.string.taxes_and_charges, 40),
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.secondary,
                    modifier = Modifier.padding(top = 4.dp)
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = stringResource(id = R.string.total),
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.secondary,

                        )
                    Text(
                        text = total.toString(),
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.primary,
                        modifier = Modifier.padding(start = 2.dp)

                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Button(
                        shape = MaterialTheme.shapes.medium,
                        onClick = {
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = stringResource(id = R.string.check_out
                            )
                        )
                    }
                }
            } else {
                //show card is empty
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun CartScreenPreview() {
    SneakersAppTheme() {
        CartScreen(
        )
    }
}