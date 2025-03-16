package com.example.gymmetercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gymmetercompose.navigation.AppScreens
import com.example.gymmetercompose.ui.components.BottomNavigationBar
import com.example.gymmetercompose.ui.components.MyTopAppBar
import com.example.gymmetercompose.ui.screens.ConfigScreen
import com.example.gymmetercompose.ui.screens.HomeScreen
import com.example.gymmetercompose.ui.screens.NewRoutineScreen
import com.example.gymmetercompose.ui.screens.ProfileScreen
import com.example.gymmetercompose.ui.screens.SplashScreen
import com.example.gymmetercompose.ui.screens.StatsScreen
import com.example.gymmetercompose.ui.theme.GymMeterComposeTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GymMeterComposeTheme {
                MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { MyTopAppBar(navController) },
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,startDestination = AppScreens.SplashScreen.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(AppScreens.SplashScreen.route) { SplashScreen(navController) }
            composable(AppScreens.HomeScreen.route) { HomeScreen(navController) }
            composable(AppScreens.StatsScreen.route) { StatsScreen(navController) }
            composable(AppScreens.NewRoutineScreen.route) { NewRoutineScreen(navController) }
            composable(AppScreens.ConfigurScreen.route) { ConfigScreen(navController) }
            composable(AppScreens.ProfileScreen.route) { ProfileScreen(navController) }
        }
    }
}