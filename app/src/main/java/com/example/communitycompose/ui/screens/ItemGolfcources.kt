package com.example.communitycompose.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.communitycompose.R
import com.example.communitycompose.custom.MSpacer
import com.example.communitycompose.ui.theme.Silver
import com.example.communitycompose.ui.theme.TextColorTime
import com.example.communitycompose.ui.theme.poppinsFontFamily

@Preview
@Composable
fun ItemGolfCourse() {

    var rating by remember { mutableStateOf(3) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(270.dp)
            .padding(top = 5.dp, bottom = 5.dp),
        elevation = CardDefaults.cardElevation(5.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(20.dp)
    ) {

        ConstraintLayout(modifier = Modifier.fillMaxSize()) {

            val (courseImage, courseName, coursePrice, ratingContainer, tvTime, timeRow) = createRefs()
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
                    .constrainAs(courseImage) {},
                painter = painterResource(id = R.drawable.golf_course),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )

            Text(
                modifier = Modifier.constrainAs(courseName) {
                    start.linkTo(parent.start, 15.dp)
                    top.linkTo(courseImage.bottom, 10.dp)
                },
                text = "Sunnyvale Golf Course",
                style = TextStyle(
                    color = Color.Black,
                    fontFamily = poppinsFontFamily,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )

            Text(
                modifier = Modifier.constrainAs(coursePrice) {
                    end.linkTo(parent.end, 15.dp)
                    top.linkTo(courseImage.bottom, 10.dp)
                },
                text = "\$40 - \$32",
                style = TextStyle(
                    color = Color.Black,
                    fontFamily = poppinsFontFamily,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )

            Row(
                modifier = Modifier.constrainAs(ratingContainer) {
                    start.linkTo(courseName.start)
                    top.linkTo(courseName.bottom, 5.dp)
                },
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    modifier = Modifier
                        .height(20.dp)
                        .width(15.dp),
                    painter = painterResource(id = R.drawable.gps_location_icon),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(color = Silver)
                )

                MSpacer(space = 2)

                Text(
                    text = "24 Mi", style = TextStyle(
                        color = TextColorTime,
                        fontWeight = FontWeight.Medium,
                        fontFamily = poppinsFontFamily,
                        fontSize = 15.sp
                    )
                )

                MSpacer(space = 2)

                RatingBar(numOfStars = 5, rating = rating.toFloat(), onRatingChanged = {
                    rating = it
                })

                MSpacer(space = 2)

                Text(
                    text = "300", style = TextStyle(
                        color = TextColorTime,
                        fontWeight = FontWeight.Medium,
                        fontFamily = poppinsFontFamily,
                        fontSize = 15.sp
                    )
                )

            }

            Text(
                modifier = Modifier.constrainAs(tvTime) {
                    end.linkTo(coursePrice.end)
                    top.linkTo(courseName.bottom, 5.dp)
                },
                text = "7AM - 3PM", style = TextStyle(
                    color = TextColorTime,
                    fontWeight = FontWeight.Medium,
                    fontFamily = poppinsFontFamily,
                    fontSize = 15.sp
                )
            )

            LazyRow(modifier = Modifier
                .padding(start = 12.dp, end = 12.dp)
                .constrainAs(timeRow) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(ratingContainer.bottom, 10.dp)
                }) {

                items(15) {
                    ItemTime()
                }

            }

        }

    }

}