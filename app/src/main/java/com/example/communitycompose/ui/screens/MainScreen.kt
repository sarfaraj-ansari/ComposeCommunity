package com.example.communitycompose.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.communitycompose.R
import com.example.communitycompose.custom.MSpacer
import com.example.communitycompose.navigation.BottomNavigationBar
import com.example.communitycompose.navigation.MainScreens
import com.example.communitycompose.navigation.NavigationGraph
import com.example.communitycompose.ui.screens.bottomsheets.EventsSheet
import com.example.communitycompose.ui.screens.bottomsheets.SearchSheet
import com.example.communitycompose.ui.theme.PrimaryPink
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
fun MainScreen() {
    val navHostController = rememberNavController()
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentRoute: String? = navBackStackEntry?.destination?.route
    val scope = rememberCoroutineScope()
    val searchSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val activitySheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val eventsSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    var showSearchSheet by remember { mutableStateOf(false) }
    var showActivitySheet by remember { mutableStateOf(false) }
    var showEventsSheet by remember { mutableStateOf(false) }
    var toolBarType by remember { mutableStateOf("") }
    var showFab by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = currentRoute) {
        currentRoute?.let {
            toolBarType = it
            showFab =
                it == MainScreens.SearchScreen.route || it == MainScreens.ActivityScreen.route || it == MainScreens.EventsScreen.route
        }
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .statusBarsPadding(),
        bottomBar = {
            println("executed--------------bottomBar")
            BottomNavigationBar(
                navHostController = navHostController,
                currentRoute = currentRoute
            )
        },
        floatingActionButton = {
            println("executed--------------outer")
            if (showFab) {
                Column {
                    if (currentRoute == MainScreens.SearchScreen.route) {
                        MFloatingActionButton(
                            onFabClicked = { showEventsSheet = true },
                            icon = R.drawable.panel_map,
                            fabColor = Color.White
                        )

                        MSpacer(space = 5)
                    }

                    MFloatingActionButton(
                        onFabClicked = {
                            when (currentRoute) {
                                MainScreens.SearchScreen.route -> {
                                    showSearchSheet = true
                                }

                                MainScreens.ActivityScreen.route -> {

                                }

                                else -> {

                                }
                            }
                        },
                        icon = R.drawable.ic_filter,
                        fabColor = PrimaryPink
                    )
                }
            }
        }
    ) {

        if (showSearchSheet) {
            SearchSheet()
        }

        if (showEventsSheet) {
            EventsSheet(
                eventsSheetState = eventsSheetState,
                onDismissSheet = {
                    showEventsSheet = !showEventsSheet
                },
                dismissIconClicked = {
                    scope.launch {
                        eventsSheetState.hide()
                    }.invokeOnCompletion {
                        if (!eventsSheetState.isVisible) {
                            showEventsSheet = false
                        }
                    }
                }
            )
        }

        Column {

            ToolBar(toolbarType = toolBarType)

            NavigationGraph(navHostController = navHostController)

        }
    }

}