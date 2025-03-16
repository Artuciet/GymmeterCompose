package com.example.gymmetercompose.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gymmetercompose.R
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun ProfileScreen(navController: NavController) {
    ProfileScreenContent(navController)
}

@Composable
fun ProfileScreenContent(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF111111))
    ) {
        // Scroll Vertical
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            item {
                // Grupo de 3 Botones Circulares
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Botón Compartir
                    CircularButton(
                        navController = navController,
                        onClick = { /*TODO: Handle share button click*/ },
                        icon = R.drawable.ic_share,
                        size = 50.dp,
                    )

                    // Botón Imagen de Perfil con Botón Agregar
                    Box(contentAlignment = Alignment.BottomEnd) {
                        Box(
                            modifier = Modifier
                                .size(120.dp)
                                .clip(CircleShape)
                                .background(Color.Gray), // Fondo gris para el círculo
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_profile), // Reemplaza con la imagen de perfil
                                contentDescription = "Profile Picture",
                                modifier = Modifier
                                    .size(120.dp)
                                    .clip(CircleShape),
                                contentScale = ContentScale.Crop
                            )
                        }
                        CircularButton(
                            navController = navController,
                            onClick = { /*TODO: Handle add image button click*/ },
                            icon = R.drawable.ic_new_routine,
                            size = 50.dp,
                        )
                    }

                    // Botón Editar
                    CircularButton(
                        navController = navController,
                        onClick = { /*TODO: Handle edit button click*/ },
                        icon = R.drawable.ic_edit,
                        size = 50.dp,
                    )
                }
            }

            // Grupo de 7 Botones Interactivos (sin iconos)
            val buttonTexts = listOf(
                "Primer Nombre:",
                "Segundo Nombre:",
                "Primer Apellido",
                "Segundo Apellido:",
                "Edad:",
                "Sexo:",
                "Pais:"
            )
            items(buttonTexts.size) { index ->
                InteractiveButton(
                    navController = navController,
                    text = buttonTexts[index],
                    backgroundColor = Color(0xFF56D7C8),
                    textColor = Color(0xFF111111),
                    modifier = Modifier.padding(horizontal = 30.dp)
                ) {
                    /*TODO: Handle button click*/
                }
                Spacer(modifier = Modifier.height(20.dp))
            }

            item {
                // Grupo de 2 Botones Interactivos (uno al lado del otro)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    InteractiveButton(
                        navController = navController,
                        modifier = Modifier.weight(1f),
                        text = "Button 8",
                        backgroundColor = Color(0xFF56D7C8),textColor = Color(0xFF111111)
                    ) {
                        /*TODO: Handle button 8 click*/
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    InteractiveButton(
                        navController = navController,
                        modifier = Modifier.weight(1f),
                        text = "Button 9",
                        backgroundColor = Color(0xFF56D7C8),
                        textColor = Color(0xFF111111)
                    ) {
                        /*TODO: Handle button 9 click*/
                    }
                }
            }
        }
    }
}

@Composable
fun CircularButton(
    navController: NavController,
    onClick: () -> Unit,
    icon: Int,
    size: Dp,
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .size(size)
            .clip(CircleShape)
            .background(Color.Transparent) // Eliminar el fondo
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = Color.White // Asegurar que el icono sea blanco
        )
    }
}

@Composable
fun InteractiveButton(
    navController: NavController,
    modifier: Modifier = Modifier,
    text: String,
    backgroundColor: Color,
    textColor: Color,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(40.dp), // Reducir la altura
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
        contentPadding = PaddingValues(horizontal = 16.dp) // Agregar padding horizontal
    ) {
        Text(
            text = text,
            color = textColor,
            textAlign = TextAlign.Start, // Alinear el texto a la izquierda
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    val navController = rememberNavController()
    ProfileScreenContent(navController)
}