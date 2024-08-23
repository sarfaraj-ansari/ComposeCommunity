package com.example.communitycompose.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.communitycompose.R
import com.example.communitycompose.custom.MSpacer
import com.example.communitycompose.navigation.MainScreens
import com.example.communitycompose.ui.theme.Black
import com.example.communitycompose.ui.theme.BorderColor
import com.example.communitycompose.ui.theme.poppinsFontFamily

@Preview
@Composable
fun ToolBar(toolbarType: String = MainScreens.HomeScreen.route) {

    Box(
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, top = 10.dp)
    ) {


        if (toolbarType == MainScreens.HomeScreen.route) {
            Column(modifier = Modifier.align(Alignment.CenterStart)) {
                Text(
                    modifier = Modifier,
                    text = "Welcome Cristian!",
                    style = TextStyle(
                        color = Black,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = poppinsFontFamily,
                        fontSize = 22.sp,
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        )
                    )
                )

                Text(
                    modifier = Modifier,
                    text = "Gold Member",
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }

        val text = when (toolbarType) {
            MainScreens.SearchScreen.route -> "Search"
            MainScreens.ActivityScreen.route -> "Activity"
            MainScreens.EventsScreen.route -> "Events"
            MainScreens.ProfileScreen.route -> "Profile"
            MainScreens.EventRegistrationScreen.route -> "Event Registration"
            else -> ""
        }

        Text(
            modifier = Modifier.align(Alignment.Center),
            text = text,
            style = TextStyle(
                color = Black,
                fontWeight = FontWeight.SemiBold,
                fontFamily = poppinsFontFamily,
                fontSize = 22.sp,
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            )
        )

        Row(
            modifier = Modifier.align(Alignment.CenterEnd),
            verticalAlignment = Alignment.CenterVertically
        ) {

            if (toolbarType == MainScreens.ProfileScreen.route) {

                Image(
                    modifier = Modifier,
                    painter = painterResource(id = R.drawable.share_toolbar),
                    contentDescription = null,
                )

                MSpacer(space = 5)
            }

            Image(
                modifier = Modifier,
                painter = painterResource(id = R.drawable.message_icon),
                contentDescription = null
            )

            MSpacer(space = 5)

            Image(
                modifier = Modifier,
                painter = painterResource(id = R.drawable.notification_icon),
                contentDescription = null
            )

            if (toolbarType == MainScreens.ProfileScreen.route) {

                MSpacer(space = 5)

                Image(
                    modifier = Modifier,
                    painter = painterResource(id = R.drawable.settings),
                    contentDescription = null,
                )
            }


            if (toolbarType == MainScreens.HomeScreen.route) {
                MSpacer(space = 5)

                Box(
                    modifier = Modifier
                        .height(40.dp)
                        .width(45.dp)
                        .border(
                            width = 1.dp,
                            color = BorderColor,
                            shape = RoundedCornerShape(3.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {

                    Image(
                        modifier = Modifier
                            .height(35.dp)
                            .width(40.dp),
                        painter = painterResource(id = R.drawable.scanner_icon),
                        contentDescription = null,
                        contentScale = ContentScale.Fit
                    )

                }
            }

        }
    }
}
