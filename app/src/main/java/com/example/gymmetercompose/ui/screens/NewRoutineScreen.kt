package com.example.gymmetercompose.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@Composable
fun NewRoutineScreen(navController: NavController) {
    NewRoutineScreenContent()
}

@Composable
fun NewRoutineScreenContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "New Routine Screen")
    }
}

@Preview(showBackground = true)
@Composable
fun NewRoutineScreenPreview() {
    NewRoutineScreenContent()
}