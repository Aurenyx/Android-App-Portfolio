package com.mrgogu.captaingame

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mrgogu.captaingame.ui.theme.CaptainGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CaptainGameTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CaptainGame(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun CaptainGame(modifier: Modifier) {
    val treasurefound = remember { mutableStateOf(0) }
    val direction =remember { mutableStateOf("North") }
    val stormorTeasure = remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text(text = "Captain Game\n", fontSize = 50.sp, color = Color.Cyan, fontFamily = FontFamily.Cursive, modifier = Modifier.padding(60.dp))
        Text(text = "Treasure Found: ${treasurefound.value}")
        Text(text = " Current Direction: ${direction.value}")
        Text(text = stormorTeasure.value)
        val context = LocalContext.current
        Button(onClick ={


            direction.value= "East"
            if(Random.nextBoolean()){
                treasurefound.value++
                Toast.makeText(context, "Treasure Found!!", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context, "Storm Ahead!!", Toast.LENGTH_SHORT).show()
            }
        }
        ) {
            Text(text = "Sail East")
        }
        Button(onClick ={
            direction.value= "North"
            if(Random.nextBoolean()){
                treasurefound.value++
                Toast.makeText(context, "Treasure Found!!", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context, "Storm Ahead!!", Toast.LENGTH_SHORT).show()
            }
        }
        ) {
            Text(text = "Sail North")
        }
        Button(onClick ={
            direction.value= "West"
            if(Random.nextBoolean()){
                treasurefound.value++
                Toast.makeText(context, "Treasure Found!!", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context, "Storm Ahead!!", Toast.LENGTH_SHORT).show()
            }
        }
        ) {
            Text(text = "Sail West")
        }
        Button(onClick ={
            direction.value= "South"
            if(Random.nextBoolean()){
                treasurefound.value++
                Toast.makeText(context, "Treasure Found!!", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context, "Storm Ahead!!", Toast.LENGTH_SHORT).show()
            }
        }
        ) {
            Text(text = "Sail South")
        }
    }
}
@Preview
@Composable
fun CaptainGamePreview() {
    CaptainGame(modifier = Modifier)
}