package com.example.communitycompose.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.communitycompose.R
import com.example.communitycompose.custom.MSpacer
import com.example.communitycompose.data.getWeatherTabData
import com.example.communitycompose.ui.theme.Black
import com.example.communitycompose.ui.theme.BorderColor
import com.example.communitycompose.ui.theme.PrimaryPink
import com.example.communitycompose.ui.theme.poppinsFontFamily

@Preview
@Composable
fun Search() {

    var selectedTabPosition by remember { mutableIntStateOf(0) }
    var searchedText by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(top = 15.dp)) {
        LazyVerticalGrid(
            GridCells.Fixed(5),
            modifier = Modifier.padding(start = 15.dp, end = 15.dp)
        ) {

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

        MSpacer(space = 10)

        Row(
            modifier = Modifier
                .padding(start = 15.dp, end = 15.dp)
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
                        if(searchedText.isEmpty()) {
                            Text(text = "Search", style = TextStyle(
                                color = Color.Black
                            ))
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

        MSpacer(space = 10)

        LazyRow(
            modifier = Modifier
                .padding(start = 12.dp, end = 12.dp)
                .fillMaxWidth()
        ) {

            items(15) {
                ItemTime()
            }

        }

        MSpacer(space = 10)

        Text(
            modifier = Modifier.padding(start = 15.dp),
            text = "Golf Courses",
            style = TextStyle(
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                color = Black
            )
        )

        LazyColumn(modifier = Modifier.padding(start = 15.dp, end = 15.dp)) {
            items(15) {
                ItemGolfCourse()
            }
        }

    }

}