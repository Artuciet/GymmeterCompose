package com.example.gymmetercompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.gymmetercompose.ui.screens.ConfigScreen
import com.example.gymmetercompose.ui.screens.HomeScreen
import com.example.gymmetercompose.ui.screens.NewRoutineScreen
import com.example.gymmetercompose.ui.screens.ProfileScreen
import com.example.gymmetercompose.ui.screens.SplashScreen
import com.example.gymmetercompose.ui.screens.StatsScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = AppScreens.SplashScreen.route) {
        composable(AppScreens.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(AppScreens.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(AppScreens.StatsScreen.route){
            StatsScreen(navController = navController)
        }
        composable(AppScreens.NewRoutineScreen.route) {
            NewRoutineScreen(navController = navController)
        }
        composable(AppScreens.ConfigurScreen.route) {
            ConfigScreen(navController = navController)
        }
        composable(AppScreens.ProfileScreen.route) {
            ProfileScreen(navController = navController)
        }
    }
}