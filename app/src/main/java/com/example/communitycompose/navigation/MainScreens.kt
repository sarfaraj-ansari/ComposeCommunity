package com.example.communitycompose.navigation

sealed class MainScreens(val route: String) {
     data object HomeScreen: MainScreens("HomeScreen")
     data object SearchScreen: MainScreens("SearchScreen")
     data object ActivityScreen: MainScreens("ActivityScreen")
     data object EventsScreen: MainScreens("EventsScreen")
     data object ProfileScreen: MainScreens("ProfileScreen")
     data object EventRegistrationScreen: MainScreens("EventRegistrationScreen")
}