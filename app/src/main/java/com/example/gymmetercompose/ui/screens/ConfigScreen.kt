package com.example.gymmetercompose.ui.screens

import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import android.content.res.Configuration
import android.os.Build
import android.provider.Settings
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gymmetercompose.R
import com.example.gymmetercompose.ui.theme.myBackground
import kotlinx.coroutines.delay
import java.util.Locale

@Composable
fun ConfigOption(
    text: String,
    icon: Int,
    isVip: Boolean = false,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    var buttonColor by remember { mutableStateOf(Color(0xFF56D7C8)) }

    LaunchedEffect(isPressed) {
        if (isPressed) {
            buttonColor = Color(0xFF00F0FF)
            delay(100)
        } else {
            buttonColor = Color(0xFF56D7C8)
        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(buttonColor)
            .clickable(interactionSource = interactionSource, indication = null) {
                onClick()
            }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = text,
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Text(
                text = text,
                color = Color.Black,
                style = MaterialTheme.typography.bodyLarge
            )
        }
        if (isVip) {
            Icon(
                painter = painterResource(id = R.drawable.ic_lock),
                contentDescription = "VIP",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun ConfigScreen(navController: NavController) {
    ConfigScreenContent()
}

@Composable
fun ConfigScreenContent() {
    var brightnessLevel by remember { mutableFloatStateOf(0.5f) }
    var showBrightnessDialog by remember { mutableStateOf(false) }
    var currentLanguage by remember { mutableStateOf("English") }
    var isDarkMode by remember { mutableStateOf(false) }
    var isVip by remember { mutableStateOf(false) }
    var showLocation by remember { mutableStateOf(false) }
    var showLanguageList by remember { mutableStateOf(false) }

    val languages = listOf(
        "Español", "English", "Italiano", "日本語", "Français", "Deutsch",
        "Português", "Русский", "中文", "한국어", "العربية", "हिन्दी"
    )
    val functionalLanguages = listOf("Español", "English", "Italiano", "日本語")

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(myBackground)
            .padding(16.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            item {
                ConfigOption(
                    text = "Brillo",
                    icon = R.drawable.ic_brillo,
                    onClick = { showBrightnessDialog = true }
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
            item {
                ConfigOption(text = "Dispositivos",
                    icon = R.drawable.ic_dispositivos,
                    onClick = {
                        Toast.makeText(context, "Dispositivos", Toast.LENGTH_SHORT).show()
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
            item {
                ConfigOption(
                    text = "Idioma",
                    icon = R.drawable.ic_idioma,
                    onClick = { showLanguageList = true }
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
            item {
                ConfigOption(
                    text = "Modo",
                    icon = R.drawable.ic_mode,
                    onClick = {
                        isDarkMode = !isDarkMode
                        if (isDarkMode) {
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                            Toast.makeText(context, "Modo Noche", Toast.LENGTH_SHORT).show()
                        } else {
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                            Toast.makeText(context, "Modo Día", Toast.LENGTH_SHORT).show()
                        }
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
            item {
                ConfigOption(
                    text = "Inteligencia Artificial",
                    icon = R.drawable.ic_ia,
                    isVip = true,
                    onClick = {
                        if (isVip) {
                            Toast.makeText(context, "Conectando con IA", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(context, "No eres VIP", Toast.LENGTH_SHORT).show()
                        }
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
            item {
                ConfigOption(
                    text = "Ubicación",
                    icon = R.drawable.ic_ubication,
                    onClick = {
                        showLocation = !showLocation
                        Toast.makeText(
                            context,
                            if (showLocation) "Ubicación Activada" else "Ubicación Desactivada",
                            Toast.LENGTH_SHORT).show()
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
            item {
                ConfigOption(
                    text = "Restablecer",
                    icon = R.drawable.ic_reset,
                    onClick = {
                        brightnessLevel = 0.5f
                        currentLanguage = "English"
                        isDarkMode = false
                        isVip = false
                        showLocation = false
                        Toast.makeText(context, "Configuración Restablecida", Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
    }

    if (showBrightnessDialog) {
        AlertDialog(
            onDismissRequest = { showBrightnessDialog = false },
            title = { Text("Brillo") },
            text = {
                Column {
                    Text("Nivel de Brillo: ${(brightnessLevel * 100).toInt()}%")
                    Slider(
                        value = brightnessLevel,
                        onValueChange = {
                            brightnessLevel = it
                            val brightness = (it * 255).toInt()
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                if (Settings.System.canWrite(context)) {
                                    Settings.System.putInt(
                                        context.contentResolver,
                                        Settings.System.SCREEN_BRIGHTNESS,
                                        brightness
                                    )
                                } else {
                                    Toast.makeText(
                                        context,
                                        "Permiso de escritura no concedido",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        },
                        valueRange = 0f..1f
                    )
                }
            },
            confirmButton = {
                TextButton(onClick = { showBrightnessDialog = false }) {
                    Text("Aceptar")
                }
            }
        )
    }
    if (showLanguageList) {
        AlertDialog(
            onDismissRequest = { showLanguageList = false },
            title = { Text("Selecciona un idioma") },
            text = {
                Column {
                    languages.forEach { language ->
                        Text(
                            text = language,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable{
                                    if (functionalLanguages.contains(language)) {
                                        currentLanguage = language
                                        val locale = when (language) {
                                            "Español" -> Locale("es", "ES")
                                            "English" -> Locale.ENGLISH
                                            "Italiano" -> Locale.ITALIAN
                                            "日本語" -> Locale.JAPANESE
                                            else -> Locale.getDefault()
                                        }
                                        val config =
                                            Configuration(context.resources.configuration)
                                        config.setLocale(locale)
                                        context.resources.updateConfiguration(config, context.resources.displayMetrics)
                                        Toast.makeText(
                                            context,
                                            "Idioma cambiado a $language",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    } else {
                                        Toast.makeText(
                                            context,
                                            "Idioma $language no disponible",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                    showLanguageList = false
                                }
                                .padding(8.dp)
                        )
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { showLanguageList = false }) {
                    Text("Cerrar")
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ConfigScreenPreview() {
    ConfigScreenContent()
}