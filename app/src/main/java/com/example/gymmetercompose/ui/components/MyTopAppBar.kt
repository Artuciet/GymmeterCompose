package com.example.gymmetercompose.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.gymmetercompose.R
import com.example.gymmetercompose.navigation.AppScreens
import com.example.gymmetercompose.ui.theme.myBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(navController: NavController) {
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route
    CenterAlignedTopAppBar(
        modifier = Modifier.fillMaxWidth(),
        title = { },
        navigationIcon = {
            if (currentRoute != AppScreens.SplashScreen.route) {
                val interactionSource = remember { MutableInteractionSource() }
                val isPressed by interactionSource.collectIsPressedAsState()
                IconButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.padding(start = 16.dp),
                    interactionSource = interactionSource
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_return_button),
                        contentDescription = "Back",
                        tint = Color(0xFF312F2F)
                    )
                }
            }
        },
        actions = {
            CircleOptionsButton()
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Transparent,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White,
            actionIconContentColor = Color.White
        )
    )
}

@Composable
fun CircleOptionsButton() {
    Box(
        modifier = Modifier
            .padding(end = 16.dp)
            .size(30.dp)
            .clip(CircleShape)
            .drawBehind {
                drawCircle(
                    color = Color(0xFF312F2F),
                    radius = this.size.maxDimension / 2f,
                    center = Offset(this.size.width / 2f, this.size.height / 2f)
                )
            },
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 2.dp), // Reducimos el padding del Row
            verticalAlignment = Alignment.CenterVertically
        ) {
            Canvas(modifier = Modifier.size(5.dp)) {
                drawCircle(color = myBackground)
            }
            Canvas(modifier = Modifier.size(4.dp).padding(horizontal = 2.dp)) { // Reducimos el padding de los Canvas
                drawCircle(color = myBackground)
            }
            Canvas(modifier = Modifier.size(5.dp)) {
                drawCircle(color = myBackground)
            }
            Canvas(modifier = Modifier.size(4.dp).padding(horizontal = 2.dp)) { // Reducimos el padding de los Canvas
                drawCircle(color = myBackground)
            }
            Canvas(modifier = Modifier.size(5.dp)) {
                drawCircle(color = myBackground)
            }
        }
    }
}