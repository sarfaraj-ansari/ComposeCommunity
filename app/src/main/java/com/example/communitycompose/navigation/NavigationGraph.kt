package com.example.communitycompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.communitycompose.ui.screens.Activity
import com.example.communitycompose.ui.screens.EventRegistration
import com.example.communitycompose.ui.screens.Events
import com.example.communitycompose.ui.screens.Home
import com.example.communitycompose.ui.screens.Profile
import com.example.communitycompose.ui.screens.Search

@Composable
fun NavigationGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = MainScreens.HomeScreen.route) {
        composable(MainScreens.HomeScreen.route) {
            Home(navHostController)
        }
        composable(MainScreens.SearchScreen.route) {
            Search()
        }
        composable(MainScreens.ActivityScreen.route) {
            Activity()
        }
        composable(MainScreens.EventsScreen.route) {
            Events()
        }
        composable(MainScreens.ProfileScreen.route) {
            Profile()
        }
        composable(MainScreens.EventRegistrationScreen.route) {
            EventRegistration()
        }
    }
}