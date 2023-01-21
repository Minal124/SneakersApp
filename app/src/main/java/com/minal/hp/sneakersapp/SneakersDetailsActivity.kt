package com.minal.hp.sneakersapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.minal.hp.sneakersapp.model.datamodel.CartItemInfo
import com.minal.hp.sneakersapp.ui.components.ViewPagerComponent
import com.minal.hp.sneakersapp.ui.theme.SneakersAppTheme
import com.minal.hp.sneakersapp.viewmodel.CartScreenViewModel
import com.minal.hp.sneakersapp.viewmodel.SneakersViewEvent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.parcelize.Parcelize

@AndroidEntryPoint
class SneakersDetailsActivity: ComponentActivity() {

    companion object {
        fun launch(
            context: Context,
            params: Params = Params(),
            vararg flags: Int
        ) {
            context.startActivity(getLaunchIntent(context, params, *flags))
        }

        private fun getLaunchIntent(
            context: Context, params: Params,
            vararg flags: Int
        ): Intent {
            return with(Intent(context, SneakersDetailsActivity::class.java)) {
                for (flag in flags) {
                    addFlags(flag)
                }
                putExtra("params", params)
            }
        }
    }

    @Parcelize
    data class Params(
        val id: String = "",
        val imgUrl: String = "",
        val name: String = "",
        val price: Int = 0,
        val shoe: String = "",
        val gender: String = "",
        val colorway: String = "",
    ) : Parcelable

    lateinit var params: Params

    private fun readParams(intent: Intent) {
        params = requireNotNull(intent.getParcelableExtra("params"))
    }

    private val cartScreenViewModel: CartScreenViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        readParams(intent)
        setContent {
            SneakerDetailsScreen(
                modifier = Modifier
            )
        }
    }

    @Composable
    fun SneakerDetailsScreen(
        modifier: Modifier = Modifier
    ) {
        SneakersAppTheme {
            Column(
                modifier = modifier.fillMaxSize()
            ){
                val configuration = LocalConfiguration.current
                SneakersDetailImage(
                    modifier = Modifier.size(
                        height = configuration.screenHeightDp.dp/2,
                        width = configuration.screenWidthDp.dp
                    )
                )
                SneakerDetailsCard(
                    modifier = Modifier.size(
                        height = configuration.screenHeightDp.dp/2,
                        width = configuration.screenWidthDp.dp
                    )
                )
            }
        }
    }

    @Composable
    fun SneakersDetailImage(
        modifier: Modifier = Modifier
    ) {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Center
        ) {
            Box {
                Canvas(modifier = Modifier.align(Alignment.Center).size(200.dp)) {
                    val canvasWidth = size.width
                    val canvasHeight = size.height
                    drawCircle(
                        color = Color(0xFFF7D0BF),
                        center = Offset(x = canvasWidth / 2, y = canvasHeight / 2),
                        radius = size.minDimension / 2
                    )
                }
                ViewPagerComponent()
            }
        }
    }

    @Composable
    fun SneakerDetailsCard(
        modifier: Modifier = Modifier
    ) {
        Card(
            elevation = 14.dp,
            modifier = modifier,
            shape = RoundedCornerShape(
                topStart = 32.dp,
                topEnd = 32.dp
            )
        ) {
            Column(
                modifier = Modifier.padding(24.dp)
            ) {
                Text(
                    text = params.name,
                    modifier = Modifier,
                    style = MaterialTheme.typography.h6
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "sfgfgd fgfdgd fgdfbfb fdbdfgdf gdfghfhfgh",
                    modifier = Modifier,
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.secondary
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Size (uk):",
                    modifier = Modifier,
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.secondary
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Colour:",
                    modifier = Modifier,
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.secondary
                )
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = stringResource(id = R.string.price),
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.secondary,

                        )
                    Text(
                        text = params.price.toString(),
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.primary,
                        modifier = Modifier.padding(start = 4.dp)
                        )
                    Spacer(modifier = Modifier.weight(1f))
                    Button(
                        shape = MaterialTheme.shapes.medium,
                        onClick = {
                              cartScreenViewModel.handleViewEvent(SneakersViewEvent.AddItem(
                                  CartItemInfo(
                                  id = params.id,
                                  brand = "",
                                  colorway = params.colorway,
                                  gender = params.gender,
                                  releaseDate = "",
                                  retailPrice = params.price,
                                  styleId = "",
                                  shoe = params.shoe,
                                  name = params.name,
                                  title = "",
                                  year = 2023
                              )))
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = stringResource(id = R.string.add_to_cart
                            )
                        )
                    }
                }
            }

        }
    }
}
