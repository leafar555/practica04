package com.example.practica04.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun CustomSpinner(
    selectedText: String,
    onItemSelected: (String) -> Unit
) {

    var expanded by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier.fillMaxWidth()
    ) {

        OutlinedTextField(
            value = selectedText,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier.fillMaxWidth(),

            trailingIcon = {

                IconButton(
                    onClick = {
                        expanded = true
                    }
                ) {

                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Abrir opciones"
                    )
                }
            }
        )


        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {


            DropdownMenuItem(

                text = {
                    Text("Elemento A")
                },

                onClick = {

                    onItemSelected("Elemento A")

                    expanded = false
                }
            )


            DropdownMenuItem(

                text = {
                    Text("Elemento B")
                },

                onClick = {

                    onItemSelected("Elemento B")

                    expanded = false
                }
            )


            DropdownMenuItem(

                text = {
                    Text("Elemento C")
                },

                onClick = {

                    onItemSelected("Elemento C")

                    expanded = false
                }
            )
        }
    }
}

