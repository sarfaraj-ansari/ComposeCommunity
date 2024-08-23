package com.example.communitycompose.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.communitycompose.data.getMenuItem
import com.example.communitycompose.ui.theme.Black
import com.example.communitycompose.ui.theme.PrimaryPink
import com.example.communitycompose.ui.theme.poppinsFontFamily

@Preview
@Composable
fun BottomNavigationBar(
    navHostController: NavHostController? = null,
    currentRoute: String? = null
) {

    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
        tonalElevation = 20.dp,
        shadowElevation = 20.dp
    ) {

        NavigationBar(
            modifier = Modifier.height(100.dp),
            containerColor = Color.White
        ) {

            getMenuItem().forEachIndexed { _, menuItem ->
                NavigationBarItem(
                    selected = currentRoute == menuItem.route,
                    icon = {
                        Icon(
                            modifier = Modifier.padding(10.dp),
                            painter = painterResource(id = menuItem.image),
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(
                            text = menuItem.title, style = TextStyle(

                                fontFamily = poppinsFontFamily,
                                fontWeight = FontWeight.Medium
                            )
                        )
                    },
                    alwaysShowLabel = true,
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = PrimaryPink,
                        selectedTextColor = PrimaryPink,
                        unselectedIconColor = Black,
                        unselectedTextColor = Black,
                        indicatorColor = Color.White
                    ),
                    onClick = {
                        navHostController?.navigate(menuItem.route) {
                            launchSingleTop = true
                            restoreState = true
                            popUpTo(MainScreens.HomeScreen.route) {
                                saveState = true
                            }
                        }
                    }
                )
            }

        }

    }

}