package com.example.communitycompose.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.communitycompose.R
import com.example.communitycompose.custom.MSpacer
import com.example.communitycompose.data.getWeatherTabData
import com.example.communitycompose.navigation.MainScreens
import com.example.communitycompose.ui.theme.Black
import com.example.communitycompose.ui.theme.BorderColor
import com.example.communitycompose.ui.theme.PrimaryPink
import com.example.communitycompose.ui.theme.poppinsFontFamily

@Preview
@Composable
fun Home(navHostController: NavHostController? = null) {

    var isCollapsed by remember { mutableStateOf(false) }
    var searchedText by remember { mutableStateOf("") }
    var selectedTabPosition by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()
            .background(color = Color.White)
    ) {

        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

            Image(
                modifier = Modifier
                    .height(30.dp)
                    .width(20.dp),
                painter = painterResource(id = R.drawable.gps_location_icon),
                contentDescription = null
            )

            MSpacer(space = 5)

            Text(text = "Deep Cliff Golf Course", style = MaterialTheme.typography.headlineMedium)

            Text(
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.End,
                maxLines = 1,
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            textDecoration = TextDecoration.Underline
                        )
                    ) {
                        append("Change")
                    }
                },
                color = PrimaryPink,
                style = MaterialTheme.typography.headlineMedium
            )

        }

        MSpacer(space = 10)

        Divider(modifier = Modifier.fillMaxWidth(), color = BorderColor)

        MSpacer(space = 10)

        Image(
            modifier = Modifier
                .clickable { isCollapsed = !isCollapsed }
                .rotate(if (isCollapsed) 180f else 0f)
                .height(15.dp)
                .width(20.dp)
                .align(Alignment.CenterHorizontally),
            painter = painterResource(id = R.drawable.arrow_icon),
            contentDescription = null,
        )

        MSpacer(space = 10)

        AnimatedVisibility(visible = !isCollapsed) {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(color = Color.White)
            ) {
                val (border1, border2, points, pointsTitle, tokens, tokensTitle, rounds, roundsTitle, divider, tab) = createRefs()

                Box(modifier = Modifier
                    .width(1.dp)
                    .height(30.dp)
                    .background(color = BorderColor)
                    .constrainAs(border1) {
                        start.linkTo(parent.start)
                        end.linkTo(border2.start)
                        top.linkTo(points.top)
                        bottom.linkTo(pointsTitle.bottom)
                    })

                Box(modifier = Modifier
                    .width(1.dp)
                    .height(30.dp)
                    .background(color = BorderColor)
                    .constrainAs(border2) {
                        end.linkTo(parent.end)
                        start.linkTo(border1.end)
                        top.linkTo(tokens.top)
                        bottom.linkTo(tokensTitle.bottom)
                    })

                Text(
                    modifier = Modifier.constrainAs(points) {
                        start.linkTo(parent.start)
                        end.linkTo(border1.start)
                    },
                    text = "02",
                    style = TextStyle(
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        color = Black
                    )
                )

                Text(
                    modifier = Modifier.constrainAs(pointsTitle) {
                        start.linkTo(parent.start)
                        end.linkTo(border1.start)
                        top.linkTo(points.bottom)
                    },
                    text = "Points",
                    style = MaterialTheme.typography.titleSmall,
                    fontSize = 12.sp,
                    color = PrimaryPink
                )

                Text(
                    modifier = Modifier.constrainAs(tokens) {
                        start.linkTo(border1.end)
                        end.linkTo(border2.start)
                    },
                    text = "12",
                    style = TextStyle(
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        color = Black
                    )
                )

                Text(
                    modifier = Modifier.constrainAs(tokensTitle) {
                        start.linkTo(border1.end)
                        end.linkTo(border2.start)
                        top.linkTo(tokens.bottom)
                    },
                    text = "Tokens",
                    style = MaterialTheme.typography.titleSmall,
                    fontSize = 12.sp,
                    color = PrimaryPink
                )

                Text(
                    modifier = Modifier.constrainAs(rounds) {
                        start.linkTo(border2.end)
                        end.linkTo(parent.end)
                    },
                    text = "13",
                    style = TextStyle(
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        color = Black
                    )
                )

                Text(
                    modifier = Modifier.constrainAs(roundsTitle) {
                        start.linkTo(border2.end)
                        end.linkTo(parent.end)
                        top.linkTo(rounds.bottom)
                    },
                    text = "Rounds",
                    style = MaterialTheme.typography.titleSmall,
                    fontSize = 12.sp,
                    color = PrimaryPink
                )

                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .constrainAs(divider) {
                            top.linkTo(pointsTitle.bottom, 15.dp)
                        }, color = BorderColor
                )

                LazyVerticalGrid(GridCells.Fixed(5), modifier = Modifier.constrainAs(tab) {
                    top.linkTo(divider.bottom, 15.dp)
                }) {

                    itemsIndexed(getWeatherTabData()) { index, item ->
                        ItemWeatherTab(
                            item,
                            selectedTabColor = if (index == selectedTabPosition) PrimaryPink else BorderColor,
                            index = index,
                            onTabSelected = {
                                selectedTabPosition = index
                            }
                        )
                    }
                }
            }
        }

        MSpacer(space = 10)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
        ) {

            Row(
                modifier = Modifier
                    .height(50.dp)
                    .weight(0.5f)
                    .border(width = 2.dp, color = BorderColor, shape = RoundedCornerShape(6.dp)),
                verticalAlignment = Alignment.CenterVertically
            ) {

                MSpacer(space = 6)

                Image(
                    painter = painterResource(id = R.drawable.search_icon),
                    contentDescription = null
                )

                BasicTextField(
                    modifier = Modifier.padding(start = 5.dp, end = 5.dp),
                    value = searchedText,
                    onValueChange = { searchedText = it },
                    singleLine = true,
                    decorationBox = {
                        if (searchedText.isEmpty()) {
                            Text(
                                text = "Search", style = TextStyle(
                                    color = Color.Black
                                )
                            )
                        }
                        it()
                    }
                )

                MSpacer(space = 6)

            }

            MSpacer(space = 5)

            Row(
                modifier = Modifier
                    .height(50.dp)
                    .weight(0.3f)
                    .border(width = 2.dp, color = BorderColor, shape = RoundedCornerShape(6.dp)),
                verticalAlignment = Alignment.CenterVertically
            ) {

                MSpacer(space = 6)

                Text(text = "On-Course")

                MSpacer(space = 6)
            }

        }

        MSpacer(space = 4)

        Column(
            modifier = Modifier
                .background(color = Color.White)
                .verticalScroll(rememberScrollState())
        ) {

            MSpacer(space = 16)

            Box(Modifier.fillMaxWidth()) {

                Text(
                    modifier = Modifier.align(Alignment.CenterStart),
                    text = "Golf Courses",
                    style = TextStyle(
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp,
                        color = Black
                    )
                )

                Text(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .clickable { navHostController?.navigate(MainScreens.EventRegistrationScreen.route) },
                    text = "View All",
                    textDecoration = TextDecoration.Underline,
                    style = TextStyle(
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        color = PrimaryPink
                    )
                )

            }

            repeat((0..1).count()) {
                ItemGolfCourse()
            }

            MSpacer(space = 10)

            Box(Modifier.fillMaxWidth()) {

                Text(
                    modifier = Modifier.align(Alignment.CenterStart),
                    text = "Activity",
                    style = TextStyle(
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp,
                        color = Black
                    )
                )

                Text(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    text = "View All",
                    textDecoration = TextDecoration.Underline,
                    style = TextStyle(
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        color = PrimaryPink
                    )
                )

            }

            repeat((0..2).count()) {
                ItemActivity()
            }

            MSpacer(space = 10)

            Box(Modifier.fillMaxWidth()) {

                Text(
                    modifier = Modifier.align(Alignment.CenterStart),
                    text = "Events",
                    style = TextStyle(
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp,
                        color = Black
                    )
                )

                Text(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    text = "View All",
                    textDecoration = TextDecoration.Underline,
                    style = TextStyle(
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        color = PrimaryPink
                    )
                )

            }

            repeat((0..2).count()) {
                ItemEvents()
            }

            MSpacer(space = 50)
        }

    }

}