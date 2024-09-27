package cl.bootcamp.myapplication7.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cl.bootcamp.myapplication7.R

@Composable
fun MainScreen() {
    // Estados para manejar la visibilidad de la imagen y el mensaje
    val showImage = remember { mutableStateOf(false) }
    val messageState = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        // Texto de bienvenida
        Text(
            text = "Bienvenido a mi aplicación",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        // Texto con mi nombre
        Text(
            text = "Daniela Puebla",
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal
        )

        // Mostrar botón según el estado de la imagen
        if (showImage.value) {
            // Botón para ocultar la imagen
            Button(onClick = {
                messageState.value = "" // Limpiar el mensaje
                showImage.value = false // Ocultar la imagen
            }) {
                Text("Ocultar imagen")
            }
        } else {
            // Botón para mostrar la imagen
            Button(onClick = {
                messageState.value = "¡Botón clickeado con exito!" // Acción 1
                showImage.value = true // Mostrar la imagen
            }) {
                Text("Mostrar imagen")
            }
        }

        // Mostrar mensaje adicional si se ha clickeado en el botón
        if (messageState.value.isNotEmpty()) {
            Text(
                text = messageState.value,
                fontSize = 18.sp,
                modifier = Modifier.padding(top = 16.dp)
            )
        }

        // Espacio para separar la imagen
        Spacer(modifier = Modifier.height(32.dp))


        // Mostrar la imagen si showImage es verdadero
        if (showImage.value) {
            Image(
                painter = painterResource(id = R.drawable.paisaje1),
                contentDescription = "Paisaje Gran canon",
                modifier = Modifier
                    .padding(top = 16.dp)
                    .size(500.dp) // se ajusta el tamaño de la imagen
            )
        }
    }
}