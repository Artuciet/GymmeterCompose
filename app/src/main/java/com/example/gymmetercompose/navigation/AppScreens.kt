package com.example.gymmetercompose.navigation

import com.example.gymmetercompose.R

sealed class AppScreens(val route: String, val icon: Int) {
    object SplashScreen : AppScreens("splash_screen", R.drawable.ic_home)
    object HomeScreen : AppScreens("home_screen", R.drawable.ic_home)
    object StatsScreen : AppScreens("stats_screen", R.drawable.ic_stats)
    object NewRoutineScreen : AppScreens("new_routine_screen", R.drawable.ic_new_routine)
    object ConfigurScreen : AppScreens("configur_screen", R.drawable.ic_configur)
    object ProfileScreen : AppScreens("profile_screen", R.drawable.ic_profile)
}