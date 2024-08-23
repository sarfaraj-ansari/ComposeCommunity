package com.example.communitycompose.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.communitycompose.R
import com.example.communitycompose.ui.theme.PrimaryPink
import com.example.communitycompose.ui.theme.TextColorTime
import com.example.communitycompose.ui.theme.poppinsFontFamily

@Preview
@Composable
fun ItemActivity() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp, bottom = 5.dp)
            .height(160.dp),
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

                val (userImage, tvHeading, button, tvTime, tvOpenSpots) = createRefs()

                Image(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(shape = CircleShape)
                        .constrainAs(userImage) {},
                    painter = painterResource(id = R.drawable.dp_img),
                    contentDescription = null
                )

                Text(
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .constrainAs(tvHeading) {
                        top.linkTo(userImage.top)
                        bottom.linkTo(userImage.bottom)
                        start.linkTo(userImage.end, 10.dp)
                    },
                    text = "Sahil is playing at Bayview Golf Club", style = TextStyle(
                        color = Color.Black,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp
                    ),
                    maxLines = 1
                )

                Button(
                    modifier = Modifier
                        .height(50.dp)
                        .constrainAs(button) {
                            end.linkTo(parent.end)
                            top.linkTo(userImage.bottom)
                        },
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(PrimaryPink),
                    shape = RoundedCornerShape(13.dp)
                ) {
                    Text(
                        text = "Request to Join", style = TextStyle(
                            color = Color.White,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp
                        )
                    )
                }

                Text(
                    modifier = Modifier.constrainAs(tvTime) {
                        start.linkTo(parent.start)
                        top.linkTo(button.top, 10.dp)
                    },
                    text = "Saturday 3PM",
                    style = TextStyle(
                        color = TextColorTime,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 15.sp
                    )
                )

                Text(
                    modifier = Modifier.constrainAs(tvOpenSpots) {
                        start.linkTo(parent.start)
                        top.linkTo(tvTime.bottom)
                    },
                    text = "(2 open spots)",
                    style = TextStyle(
                        color = TextColorTime,
                        fontFamily = poppinsFontFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp
                    )
                )
            }

        }

    }

}
