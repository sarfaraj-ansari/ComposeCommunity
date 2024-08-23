package com.example.communitycompose.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.communitycompose.R
import com.example.communitycompose.custom.MSpacer
import com.example.communitycompose.ui.theme.Black
import com.example.communitycompose.ui.theme.PrimaryPink
import com.example.communitycompose.ui.theme.TextColorTime
import com.example.communitycompose.ui.theme.poppinsFontFamily

@Preview
@Composable
fun ItemEvents() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp, bottom = 5.dp)
            .height(180.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

            ConstraintLayout(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(15.dp)
            ) {
                val (courseName, row1, row2, row3, button) = createRefs()
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .constrainAs(courseName) {},
                    text = "Deep Cliff Golf Course is hosting a\n" +
                            "Golf in the dark Golf Event.",
                    maxLines = 2,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(includeFontPadding = false),
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp,
                        color = Black
                    )
                )

                Row(
                    modifier = Modifier.constrainAs(row1) {
                        start.linkTo(parent.start)
                        top.linkTo(courseName.bottom, 15.dp)
                    },
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Image(
                        modifier = Modifier
                            .size(10.dp)
                            .rotate(90f),
                        painter = painterResource(id = R.drawable.arrow_icon),
                        contentDescription = null
                    )

                    MSpacer(space = 2)

                    Text(
                        text = "Date: Friday Feb 23rd", style = TextStyle(
                            platformStyle = PlatformTextStyle(includeFontPadding = false),
                            color = Black,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp
                        )
                    )

                }

                Row(
                    modifier = Modifier.constrainAs(row2) {
                        start.linkTo(parent.start)
                        top.linkTo(row1.bottom, 10.dp)
                    },
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Image(
                        modifier = Modifier
                            .size(10.dp)
                            .rotate(90f),
                        painter = painterResource(id = R.drawable.arrow_icon),
                        contentDescription = null
                    )

                    MSpacer(space = 2)

                    Text(
                        text = "Time: 5PM-7PM", style = TextStyle(
                            platformStyle = PlatformTextStyle(includeFontPadding = false),
                            color = Black,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp
                        )
                    )

                }

                Row(
                    modifier = Modifier.constrainAs(row3) {
                        start.linkTo(parent.start)
                        top.linkTo(row2.bottom, 10.dp)
                    },
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Image(
                        modifier = Modifier
                            .size(10.dp)
                            .rotate(90f),
                        painter = painterResource(id = R.drawable.arrow_icon),
                        contentDescription = null
                    )

                    MSpacer(space = 2)

                    Text(
                        text = "Cost: \$60", style = TextStyle(
                            platformStyle = PlatformTextStyle(includeFontPadding = false),
                            color = Black,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp
                        )
                    )

                }

                Button(
                    modifier = Modifier
                        .height(50.dp)
                        .constrainAs(button) {
                            end.linkTo(parent.end)
                            bottom.linkTo(parent.bottom)
                        },
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(PrimaryPink),
                    shape = RoundedCornerShape(13.dp)
                ) {
                    Text(
                        text = "Register Now", style = TextStyle(
                            color = Color.White,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp
                        )
                    )
                }
            }

        }

    }

}