package com.example.communitycompose.ui.screens.bottomsheets

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.communitycompose.custom.MSpacer
import com.example.communitycompose.ui.theme.PrimaryPink
import com.example.communitycompose.ui.theme.TextColorTime
import com.example.communitycompose.ui.theme.poppinsFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchSheet() {
    var selected by remember { mutableIntStateOf(4) }
    ModalBottomSheet(
        sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
        containerColor = Color.White,
        onDismissRequest = { }
    ) {
        SearchSheetContent(selected = selected, sortByChip = { pos ->
            selected = pos
        })
    }

}

@Preview
@Composable
fun SearchSheetContent(
    selected: Int = 0,
    sortByChip: (position: Int) -> Unit = {}
) {

    Column(modifier = Modifier.fillMaxSize()) {

        Box(
            modifier = Modifier
                .padding(start = 15.dp, end = 15.dp)
                .fillMaxWidth()
                .wrapContentHeight()

        ) {

            Text(
                modifier = Modifier.align(Alignment.CenterStart),
                text = "Filters", style = TextStyle(
                    color = Color.Black,
                    fontFamily = poppinsFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp
                )
            )

            Icon(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .size(30.dp),
                imageVector = Icons.Default.Close,
                contentDescription = null
            )
        }

        MSpacer(space = 5)

        Divider()

        MSpacer(space = 10)

        Text(
            modifier = Modifier.padding(start = 15.dp),
            text = "Sort By", style = TextStyle(
                color = Color.Black,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp
            )
        )

        Text(
            modifier = Modifier.padding(start = 15.dp),
            text = "Sort your tee time results", style = TextStyle(
                color = TextColorTime,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp
            )
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(start = 15.dp, end = 15.dp)
        ) {

            //Border
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(5.dp))
            )

            ConstraintLayout(modifier = Modifier.fillMaxSize()) {

                val (divider1, divider2, divider3, divider4, tv1, tv2, tv3, tv4, tv5) = createRefs()

                //Divider 1
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp)
                        .background(color = Color.Gray)
                        .constrainAs(divider1) {
                            start.linkTo(parent.start, 10.dp)
                            end.linkTo(divider2.start)
                        }
                )

                //Divider 2
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp)
                        .background(color = Color.Gray)
                        .constrainAs(divider2) {
                            start.linkTo(divider1.end, 10.dp)
                            end.linkTo(divider3.start)
                        }
                )

                //Divider 3
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp)
                        .background(color = Color.Gray)
                        .constrainAs(divider3) {
                            start.linkTo(divider2.end)
                            end.linkTo(divider4.start)
                        }
                )

                //Divider 4
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp)
                        .background(color = Color.Gray)
                        .constrainAs(divider4) {
                            start.linkTo(divider3.end)
                            end.linkTo(parent.end)
                        }
                )

                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .clickable { sortByChip.invoke(0) }
                        .background(
                            color = if (selected == 0) PrimaryPink else Color.Transparent,
                            shape = RoundedCornerShape(topStart = 5.dp, bottomStart = 5.dp)
                        )
                        .constrainAs(tv1) {
                            start.linkTo(parent.start)
                            end.linkTo(divider1.end)
                            width = Dimension.fillToConstraints

                        },
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        modifier = Modifier,
                        text = "Best Deal",
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            color = Color.Black,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                            platformStyle = PlatformTextStyle(includeFontPadding = false)
                        )
                    )

                }

                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .clickable { sortByChip.invoke(1) }
                        .background(
                            color = if (selected == 1) PrimaryPink else Color.Transparent
                        )
                        .constrainAs(tv2) {
                            start.linkTo(divider1.start)
                            end.linkTo(divider2.end)
                            width = Dimension.fillToConstraints

                        },
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        modifier = Modifier,
                        text = "Distance",
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            color = Color.Black,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                            platformStyle = PlatformTextStyle(includeFontPadding = false)
                        )
                    )

                }

                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .clickable { sortByChip.invoke(2) }
                        .background(
                            color = if (selected == 2) PrimaryPink else Color.Transparent
                        )
                        .constrainAs(tv3) {
                            start.linkTo(divider2.start)
                            end.linkTo(divider3.end)
                            width = Dimension.fillToConstraints

                        },
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        modifier = Modifier,
                        text = "Rating",
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            color = Color.Black,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                            platformStyle = PlatformTextStyle(includeFontPadding = false)
                        )
                    )

                }

                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .clickable { sortByChip.invoke(3) }
                        .background(
                            color = if (selected == 3) PrimaryPink else Color.Transparent
                        )
                        .constrainAs(tv4) {
                            start.linkTo(divider3.start)
                            end.linkTo(divider4.end)
                            width = Dimension.fillToConstraints

                        },
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        modifier = Modifier,
                        text = "Time",
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            color = Color.Black,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                            platformStyle = PlatformTextStyle(includeFontPadding = false)
                        )
                    )

                }

                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .clickable { sortByChip.invoke(4) }
                        .background(
                            color = if (selected == 4) PrimaryPink else Color.Transparent,
                            shape = RoundedCornerShape(topEnd = 5.dp, bottomEnd = 5.dp)
                        )
                        .constrainAs(tv5) {
                            start.linkTo(divider4.start)
                            end.linkTo(parent.end)
                            width = Dimension.fillToConstraints

                        },
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        modifier = Modifier,
                        text = "Price",
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            color = Color.Black,
                            fontFamily = poppinsFontFamily,
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                            platformStyle = PlatformTextStyle(includeFontPadding = false)
                        )
                    )

                }

            }

        }

    }

}