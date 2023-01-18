package com.minal.hp.sneakersapp.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.minal.hp.sneakersapp.ui.theme.SneakersAppTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TextDropDownComponent(
    modifier: Modifier = Modifier,
    @StringRes text: Int,
) {
    var expanded by remember {
        mutableStateOf(false)
    }

    val listItems = arrayOf("Favorites", "Color", "Price", "Brand")

    var selectedItem by remember {
        mutableStateOf(listItems[0])
    }

    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(text),
            modifier = Modifier,
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.weight(1f))
        ExposedDropdownMenuBox(
            modifier = Modifier.width(150.dp),
            expanded = expanded ,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            TextField(
                value = "",
                onValueChange = {},
                readOnly = true,
                label = {
                    Text(
                        text = "Sort by",
                        modifier = Modifier.padding(start = 12.dp)
                    ) },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(
                        expanded = expanded
                    )
                },
                modifier = Modifier,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White
                ),
                textStyle = TextStyle(
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.SemiBold
                )
            )

            ExposedDropdownMenu(
                expanded = expanded,
                modifier = Modifier.background(color = Color.White),
                onDismissRequest = { expanded = false }
            ) {
                listItems.forEach { selectedOption ->
                    DropdownMenuItem(
                        onClick = {
                            selectedItem = selectedOption
                            expanded = false
                        }
                    ) {
                        Text(text = selectedOption)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TextDropDownComponentPreview() {
    SneakersAppTheme() {
        TextDropDownComponent(
            text = com.minal.hp.sneakersapp.R.string.popular
        )
    }
}