package com.example.communitycompose.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.communitycompose.R
import com.example.communitycompose.ui.theme.Black
import com.example.communitycompose.ui.theme.BorderColor
import com.example.communitycompose.ui.theme.Platinum
import com.example.communitycompose.ui.theme.PrimaryPink
import com.example.communitycompose.ui.theme.Silver
import com.example.communitycompose.ui.theme.poppinsFontFamily

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun Login(goToHome: () -> Unit = {}) {

    val listOfImage = listOf(
        R.drawable.intro_pager_image,
        R.drawable.intro_pager_image,
        R.drawable.intro_pager_image,
        R.drawable.intro_pager_image
    )
    val pagerState = rememberPagerState(pageCount = { listOfImage.size })
    var phoneNo by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .wrapContentHeight(),
            contentScale = ContentScale.FillWidth,
            painter = painterResource(id = R.drawable.logo_community),
            contentDescription = null
        )

        HorizontalPager(
            modifier = Modifier
                .padding(top = 15.dp)
                .wrapContentWidth(),
            state = pagerState
        ) {

            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Image(
                    painter = painterResource(id = listOfImage[it]),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxHeight(0.4f)
                        .fillMaxWidth(0.9f)
                        .clip(shape = RoundedCornerShape(15.dp))
                )
            }
        }

        Indicator(position = pagerState.currentPage, indicatorCount = listOfImage.size)

        Text(
            modifier = Modifier.padding(top = 15.dp),
            text = "Welcome \nCommuniTee Member!",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineLarge
        )

        Text(
            text = "Mobile Number",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp),
            textAlign = TextAlign.Start
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp)
                .height(60.dp)
                .border(
                    width = 2.dp,
                    color = BorderColor,
                    shape = RoundedCornerShape(10.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            BasicTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(start = 15.dp, end = 15.dp),
                value = phoneNo,
                onValueChange = { phoneNo = it },
                textStyle = MaterialTheme.typography.labelMedium,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                cursorBrush = SolidColor(Silver),
                singleLine = true,
                decorationBox = {
                    if (phoneNo.isEmpty()) {
                        Text(
                            text = "Enter Mobile Number",
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                    it()
                }
            )
        }

        Spacer(modifier = Modifier.padding(15.dp))

        Button(
            modifier = Modifier
                .height(60.dp)
                .width(150.dp),
            onClick = goToHome,
            elevation = ButtonDefaults.buttonElevation(5.dp),
            colors = ButtonDefaults.buttonColors(PrimaryPink),
            shape = RoundedCornerShape(5.dp)
        ) {
            Text(
                text = "Log In", style = TextStyle(
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.Medium,
                    color = Color.White,
                    fontSize = 18.sp
                )
            )
        }

        Spacer(modifier = Modifier.padding(15.dp))

        Text(
            text = "Not a member yet? \nCreate your account at our website:",
            style = TextStyle(
                fontSize = 15.sp,
                color = Black,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Normal
            ),
            textAlign = TextAlign.Center
        )

        Text(
            text = stringResource(id = R.string.email),
            style = TextStyle(
                fontSize = 15.sp,
                color = PrimaryPink,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Normal
            ),
            textAlign = TextAlign.Center
        )

    }

}

@Composable
fun Indicator(position: Int, indicatorCount: Int) {

    Row(modifier = Modifier.padding(top = 10.dp)) {

        (0..<indicatorCount).forEach { i ->
            Box(
                modifier = Modifier
                    .padding(start = 2.dp, end = 2.dp)
                    .size(10.dp)
                    .background(
                        color = if (i == position) PrimaryPink else Platinum,
                        shape = CircleShape
                    )
            )
        }

    }

}