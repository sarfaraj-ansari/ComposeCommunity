package com.example.communitycompose.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.communitycompose.R
import com.example.communitycompose.custom.MSpacer
import com.example.communitycompose.data.WeatherTab
import com.example.communitycompose.ui.theme.Black
import com.example.communitycompose.ui.theme.BorderColor
import com.example.communitycompose.ui.theme.PrimaryPink
import com.example.communitycompose.ui.theme.poppinsFontFamily

@Preview
@Composable
fun ItemWeatherTab(
    weatherTab: WeatherTab = WeatherTab(R.drawable.sun_icon, "Today"),
    selectedTabColor: Color = Black,
    index: Int = 0,
    onTabSelected: () -> Unit = {}
) {

    Column(
        modifier = Modifier.fillMaxWidth().clickable { onTabSelected.invoke() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            modifier = Modifier.wrapContentWidth(),
            text = weatherTab.title,
            style = TextStyle(
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = if(selectedTabColor == BorderColor) Black else selectedTabColor
            )
        )

        Image(
            modifier = Modifier.wrapContentWidth().height(35.dp),
            painter = painterResource(id = weatherTab.image),
            contentDescription = null
        )

        MSpacer(space = 5)

        val shape = when(index) {
            0 -> RoundedCornerShape(topStart = 5.dp, bottomStart = 5.dp, topEnd = 0.dp, bottomEnd = 0.dp)
            4 -> RoundedCornerShape(topStart = 0.dp, bottomStart = 0.dp, topEnd = 0.dp, bottomEnd = 5.dp)
            else -> RectangleShape
        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(10.dp)
            ) {

            Box(modifier = Modifier
                .fillMaxSize()
                .background(color = BorderColor, shape = shape))

            Box(modifier = Modifier
                .fillMaxSize()
                .background(color = selectedTabColor, shape = CircleShape))

        }

    }

}