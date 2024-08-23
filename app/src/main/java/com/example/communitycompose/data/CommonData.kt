package com.example.communitycompose.data

import com.example.communitycompose.R
import com.example.communitycompose.navigation.MainScreens

data class WeatherTab(val image: Int, val title: String)

fun getWeatherTabData() = listOf(WeatherTab(R.drawable.sun_icon, "Today"), WeatherTab(R.drawable.partly_cloudy_icon, "Tue 21"), WeatherTab(R.drawable.rainy_icon, "Wed 22"), WeatherTab(R.drawable.partly_cloudy_icon, "Thu 23"), WeatherTab(R.drawable.rainy_and_sunny_icon, "Fri 24"))

data class MenuItem(val route: String, val image: Int, val title: String)

fun getMenuItem() = listOf(
    MenuItem(MainScreens.HomeScreen.route, R.drawable.home_icon, "Home"),
    MenuItem(MainScreens.SearchScreen.route, R.drawable.search_icon, "Search"),
    MenuItem(MainScreens.ActivityScreen.route, R.drawable.activity_icon, "Activity"),
    MenuItem(MainScreens.EventsScreen.route, R.drawable.events_icon, "Events"),
    MenuItem(MainScreens.ProfileScreen.route, R.drawable.profile_icon, "Profile")
)

fun getChipData() = listOf("Junior", "Amateur", "Pro")

fun getChipData2() = listOf("Co-Ed", "Men", "Women")

fun getChipData3() = listOf("Any", "Tournament", "Program", "On-Course", "Off-Course")

fun getChipData4() = listOf("Any", "Social", "Charity", "Networking", "Business")