package com.example.zoonari

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zoonari.ui.theme.ZooonariTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZooonariTheme {
                // Surface es como el fondo de tu app
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Centramos el menú en la pantalla
                    Box(contentAlignment = Alignment.Center) {
                        MenuLateralScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun MenuLateralScreen() {
    val context = LocalContext.current // Necesario para mostrar Toasts

    // Esta Card actúa como el contenedor de tu menú
    Card(
        modifier = Modifier
            .width(250.dp) // Ancho del menú
            .wrapContentHeight(), // Altura basada en el contenido
        shape = RoundedCornerShape(20.dp), // Bordes redondeados
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF0F0F0)) // Color de fondo del menú
    ) {
        // Column organiza los elementos verticalmente
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp), // Padding interno
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Menú",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(32.dp)) // Espacio vertical

            // Recreamos cada botón
            MenuButton(text = "Detectar Sonido") {
                Toast.makeText(context, "Abriendo detector de sonido...", Toast.LENGTH_SHORT).show()
            }
            MenuButton(text = "Detectar Imagen") {
                Toast.makeText(context, "Abriendo detector de imagen...", Toast.LENGTH_SHORT).show()
            }
            MenuButton(text = "Registro") {
                Toast.makeText(context, "Mostrando registro...", Toast.LENGTH_SHORT).show()
            }
            MenuButton(text = "Configuración") {
                Toast.makeText(context, "Abriendo configuración...", Toast.LENGTH_SHORT).show()
            }
            MenuButton(text = "Salir") {
                Toast.makeText(context, "Cerrando la app...", Toast.LENGTH_SHORT).show()
                // (activity as? Activity)?.finish() // Código para cerrar la app de verdad
            }
        }
    }
}

// Un Composable reutilizable para los botones del menú
@Composable
fun MenuButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp), // Espacio entre botones
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White, // Color del botón
            contentColor = Color.Black // Color del texto
        ),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 2.dp)
    ) {
        Text(text = text, modifier = Modifier.padding(8.dp))
    }
}


// Esto es para previsualizar el diseño en Android Studio
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ZooonariTheme {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            MenuLateralScreen()
        }
    }
}


