package com.example.parcial_1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcial_1.ui.theme.Parcial_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally)
                {
                    Greeting(
                        name = "Parcial #1",
                    )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var contexto = LocalContext.current

    Text(
        text = "$name",
        fontSize = 35.sp,
        modifier = modifier
    )

    Spacer(modifier = Modifier.padding(20.dp))

    Text(
        text = "Kazim Jesse",
        fontSize = 25.sp,
        modifier = Modifier
    )

    Spacer(modifier = Modifier.padding(10.dp))

    ValidarCalificacion()

}

@Composable
fun ValidarCalificacion(){

    var contexto = LocalContext.current

    var Calificacion by remember { mutableStateOf("") }

    OutlinedTextField(
        value = Calificacion,
        onValueChange = {Calificacion = it},
        label = { Text("Ingrese la calificacion del grupo:") },
        textStyle = TextStyle(color = Color.Black, fontSize = 20.sp),
        modifier = Modifier.padding(20.dp)
    )
    
    Spacer(modifier = Modifier.padding(25.dp))

    Button(
        onClick = {
            val calificacion = Calificacion.toIntOrNull()

            if (calificacion != null && calificacion<=100) {
                if (calificacion <=60){
                    Toast.makeText(contexto,"No aprovado, gracias por participar", Toast.LENGTH_LONG).show()
                }else if(calificacion >= 61 && calificacion<=70){
                    Toast.makeText(contexto,"Obtuvieron una D (por los pelos)",Toast.LENGTH_LONG).show()
                }else if (calificacion>=71 && calificacion<=80){
                    Toast.makeText(contexto,"Obtuvieron una C (Regular)",Toast.LENGTH_LONG).show()
                }else if (calificacion>=81 && calificacion<=90){
                    Toast.makeText(contexto,"Obtuvieron una B (Bueno)",Toast.LENGTH_LONG).show()
                }else
                    Toast.makeText(contexto,"Obtuvieron una A (Excelente)",Toast.LENGTH_LONG).show()
            }else
                Toast.makeText(contexto,"Introduzca un numero valido",Toast.LENGTH_LONG).show()
        },
        modifier = Modifier.height(55.dp).width(130.dp)
    ) {
        Text(
            text = "Validar",
            fontSize = 15.sp
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Greeting(
            name = "Parcial #1",
        )
    }
}