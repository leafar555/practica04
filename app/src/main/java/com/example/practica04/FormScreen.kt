package com.example.practica04

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practica04.components.CustomCheckbox
import com.example.practica04.components.CustomDatePicker
import com.example.practica04.components.CustomRadioButton
import com.example.practica04.components.CustomSpinner
import com.example.practica04.components.CustomSwitch

@Composable
fun FormScreen() {

    val context =
        LocalContext.current


    // Variables que guardan la información
    // seleccionada por el usuario

    var switchActivo by remember {
        mutableStateOf(false)
    }

    var opcionSeleccionada by remember {
        mutableStateOf("Opción 1")
    }

    var aceptaTerminos by remember {
        mutableStateOf(false)
    }

    var elementoSeleccionado by remember {
        mutableStateOf("Seleccionar Opción")
    }

    var fechaSeleccionada by remember {
        mutableStateOf("Seleccionar Fecha")
    }

    var resultado by remember {
        mutableStateOf("")
    }


    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(
                rememberScrollState()
            ),

        verticalArrangement =
            Arrangement.spacedBy(16.dp)

    ) {


        Text(
            text =
                "Práctica 4: Componentes Avanzados",

            fontSize = 22.sp,

            style =
                MaterialTheme.typography.headlineMedium
        )


        HorizontalDivider()


        // 1. Switch

        Text(
            text = "1. Switch",
            style =
                MaterialTheme.typography.titleMedium
        )


        CustomSwitch(

            isChecked = switchActivo,

            onCheckedChange = {

                switchActivo = it
            }
        )


        HorizontalDivider()


        // 2. RadioButton

        Text(
            text = "2. RadioButton",

            style =
                MaterialTheme.typography.titleMedium
        )


        CustomRadioButton(

            selectedOption =
                opcionSeleccionada,

            onOptionSelected = {

                opcionSeleccionada = it
            }
        )


        HorizontalDivider()


        // 3. Checkbox

        Text(
            text = "3. Checkbox",

            style =
                MaterialTheme.typography.titleMedium
        )


        CustomCheckbox(

            isChecked =
                aceptaTerminos,

            onCheckedChange = {

                aceptaTerminos = it
            }
        )


        HorizontalDivider()


        // 4. Spinner

        Text(
            text =
                "4. Spinner (DropdownMenu)",

            style =
                MaterialTheme.typography.titleMedium
        )


        CustomSpinner(

            selectedText =
                elementoSeleccionado,

            onItemSelected = {

                elementoSeleccionado = it
            }
        )


        HorizontalDivider()


        // 5. DatePicker

        Text(
            text = "5. DatePicker",

            style =
                MaterialTheme.typography.titleMedium
        )


        CustomDatePicker(

            selectedDateText =
                fechaSeleccionada,

            onDateSelected = {

                fechaSeleccionada = it
            }
        )


        Spacer(
            modifier =
                Modifier.height(16.dp)
        )


        // Botón de procesamiento

        Button(

            onClick = {

                resultado = """

                    RESULTADO DEL FORMULARIO

                    Switch:
                    ${if (switchActivo) "Activado" else "Desactivado"}

                    RadioButton:
                    $opcionSeleccionada

                    Términos:
                    ${if (aceptaTerminos) "Aceptados" else "No aceptados"}

                    Spinner:
                    $elementoSeleccionado

                    Fecha:
                    $fechaSeleccionada

                """.trimIndent()


                Toast.makeText(
                    context,
                    "Formulario procesado correctamente",
                    Toast.LENGTH_SHORT
                ).show()
            },

            modifier =
                Modifier.fillMaxWidth()

        ) {

            Text(
                "Probar Formulario"
            )
        }


        // Resultado final

        if (resultado.isNotEmpty()) {

            Card(
                modifier =
                    Modifier.fillMaxWidth(),

                colors =
                    CardDefaults.cardColors(
                        containerColor =
                            MaterialTheme
                                .colorScheme
                                .surfaceVariant
                    )
            ) {

                Text(
                    text = resultado,

                    fontSize = 16.sp,

                    modifier =
                        Modifier.padding(16.dp)
                )
            }
        }


        Spacer(
            modifier =
                Modifier.height(30.dp)
        )
    }
}