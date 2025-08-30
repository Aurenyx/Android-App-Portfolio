package com.mrgogu.unitconverter

import android.R.attr.onClick
import android.R.attr.text
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mrgogu.unitconverter.ui.theme.UnitConverterTheme
import kotlin.math.roundToInt


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Unitconverter(modifier = Modifier.padding(innerPadding).background(Color(0xFFE3F2FD)))
                }
            }
        }
    }
}

@Composable
fun Unitconverter(modifier: Modifier = Modifier){

    var inputvalue by remember { mutableStateOf("") }
    var inputunit by remember { mutableStateOf("Select") }
    var outputunit by remember { mutableStateOf("Select") }
    var outputvalue by remember { mutableStateOf("") }
    var iexpanded by remember { mutableStateOf(false) }
    var oexpanded by remember { mutableStateOf(false) }
    val conversionFactor = remember { mutableStateOf(0.01) }
    val oconversionFactor = remember { mutableStateOf(0.01) }

    val customTextStyle = TextStyle( fontSize = 25.sp, fontWeight = FontWeight.Medium, fontFamily = FontFamily.Monospace)
    val customTextStyleResult = TextStyle( fontSize = 25.sp, fontWeight = FontWeight.Medium, fontFamily = FontFamily.Default)


    fun Converter(){
        val inputvalueDouble = inputvalue.toDoubleOrNull() ?: 0.0
        val result =(inputvalueDouble * conversionFactor.value * 100.0 / oconversionFactor.value).roundToInt()/100.0
        outputvalue = result.toString()
    }


    Column(modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Unit Converter",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color =Color(0xFF0D47A1),
            textAlign = TextAlign.Center,
            style = customTextStyle,
            modifier = Modifier.padding(16.dp))
//        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = inputvalue, onValueChange = {
            inputvalue = it
            Converter()
        },
            label = {Text("Enter value", fontSize = 20.sp) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            textStyle = TextStyle(fontSize = 25.sp, fontWeight = FontWeight.Medium, color = Color.Blue),
            modifier = Modifier.padding(16.dp))
//        Spacer(modifier = Modifier.height(16.dp))


        Row {
            //Input Box
            Box(){

                // Input Button
                Button(onClick = { iexpanded = true }) {
                    Text(inputunit, fontSize = 20.sp)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")

                    DropdownMenu(expanded = iexpanded , onDismissRequest = {iexpanded=false}) {
                        DropdownMenuItem(
                            text= {Text("Meter")},
                            onClick = {
                                inputunit = "Meter"
                                conversionFactor.value = 1.0
                                iexpanded =false
                                Converter()
                            }
                        )
                        DropdownMenuItem(
                            text= {Text("Centimeter")},
                            onClick = {
                                inputunit = "Centimeter"
                                conversionFactor.value = 0.01
                                iexpanded =false
                                Converter()
                            }
                        )
                        DropdownMenuItem(
                            text= {Text("Milimeter")},
                            onClick = {
                                inputunit = "Milimeter"
                                conversionFactor.value = 0.001
                                iexpanded =false
                                Converter()
                            }
                        )
                        DropdownMenuItem(
                            text= {Text("Feet")},
                            onClick = {
                                inputunit = "Feet"
                                conversionFactor.value = 0.3048
                                iexpanded =false
                                Converter()
                            }
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.width(10.dp))
            //Output Box
            Box(){

                // Output Button
                Button(onClick = { oexpanded = true }) {
                    Text(outputunit, fontSize = 20.sp)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
                    DropdownMenu(expanded = oexpanded, onDismissRequest = { oexpanded=false }) {
                        DropdownMenuItem(
                            text= {Text("Meter")},
                            onClick = {
                                outputunit = "Meter"
                                oconversionFactor.value = 1.0
                                oexpanded =false
                                Converter()}
                        )
                        DropdownMenuItem(
                            text= {Text("Centimeter")},
                            onClick = {
                                outputunit = "Centimeter"
                                oconversionFactor.value = 0.01
                                oexpanded =false
                                Converter()
                            }
                        )
                        DropdownMenuItem(
                            text= {Text("Milimeter")},
                            onClick = {
                                outputunit = "Milimeter"
                                oconversionFactor.value = 0.001
                                oexpanded =false
                                Converter()
                            }
                        )
                        DropdownMenuItem(
                            text= {Text("Feet")},
                            onClick = {
                                outputunit = "Feet"
                                oconversionFactor.value = 0.3048
                                oexpanded =false
                                Converter()
                            }
                        )
                    }
                }
            }

    }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Result: $outputvalue $outputunit ",
            fontSize = 25.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Blue,
            style = customTextStyleResult,
            modifier = Modifier.padding(16.dp)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun UnitconverterPreview(){
    Unitconverter()
}