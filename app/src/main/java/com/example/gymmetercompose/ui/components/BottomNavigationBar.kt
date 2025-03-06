package com.example.gymmetercompose.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.gymmetercompose.R
import com.example.gymmetercompose.navigation.AppScreens
import com.example.gymmetercompose.ui.theme.myIconSelected

@Composable
fun BottomNavigationBar(navController: NavController) {
    val screens = listOf(
        AppScreens.HomeScreen,
        AppScreens.StatsScreen,
        AppScreens.NewRoutineScreen,
        AppScreens.ConfigurScreen,
        AppScreens.ProfileScreen
    )

    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        screens.forEach { screen ->
            val isSelected = currentRoute == screen.route

            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = screen.icon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp)
                            .drawBehind {
                                if (isSelected) {
                                    drawCircle(
                                        color = myIconSelected,
                                        radius = this.size.maxDimension / 1.5f, // Aumentamos el radio
                                        center = Offset(this.size.width / 2f, this.size.height / 2f)
                                    )
                                }
                            }
                    )
                },
                selected = isSelected,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    unselectedIconColor = Color.Gray,
                    indicatorColor = Color.Transparent
                ),
                label = {}
            )
        }
    }
}