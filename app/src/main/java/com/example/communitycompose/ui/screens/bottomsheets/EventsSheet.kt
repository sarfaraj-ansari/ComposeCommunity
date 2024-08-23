package com.example.communitycompose.ui.screens.bottomsheets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.communitycompose.custom.MSpacer
import com.example.communitycompose.data.getChipData
import com.example.communitycompose.data.getChipData2
import com.example.communitycompose.data.getChipData3
import com.example.communitycompose.data.getChipData4
import com.example.communitycompose.ui.theme.PrimaryPink
import com.example.communitycompose.ui.theme.Silver
import com.example.communitycompose.ui.theme.poppinsFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventsSheet(
    eventsSheetState: SheetState,
    onDismissSheet: () -> Unit = {},
    dismissIconClicked: () -> Unit = {}
) {

    ModalBottomSheet(
        sheetState = eventsSheetState,
        onDismissRequest = onDismissSheet
    ) {
        EventsSheetContent(dismissIconClicked = dismissIconClicked)
    }

}

@OptIn(ExperimentalLayoutApi::class)
@Preview
@Composable
fun EventsSheetContent(dismissIconClicked: () -> Unit = {}) {

    var selectedChip by remember { mutableStateOf("Junior") }
    var selectedChip2 by remember { mutableStateOf("Men") }
    var selectedChip3 by remember { mutableStateOf("Program") }
    var selectedChip4 by remember { mutableStateOf("Business") }

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
                    .clickable { dismissIconClicked.invoke() }
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
            text = "Level", style = TextStyle(
                color = Color.Black,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp
            )
        )

        FlowRow(
            modifier = Modifier.padding(start = 15.dp),
            horizontalArrangement = Arrangement.spacedBy(7.dp)
        ) {

            getChipData().forEach {
                val isSelected = selectedChip == it
                Button(
                    shape = RoundedCornerShape(5.dp),
                    border = if (isSelected) null else BorderStroke(width = 1.dp, color = Silver),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isSelected) PrimaryPink else Color.White
                    ),
                    onClick = {
                        if (selectedChip == it) selectedChip = "" else selectedChip = it
                    }
                ) {
                    Text(
                        text = it,
                        style = TextStyle(
                            color = if (isSelected) Color.White else Color.Black,
                            platformStyle = PlatformTextStyle(includeFontPadding = false)

                        )
                    )
                }
            }

        }

        MSpacer(space = 10)

        Text(
            modifier = Modifier.padding(start = 15.dp),
            text = "Gender", style = TextStyle(
                color = Color.Black,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp
            )
        )

        FlowRow(
            modifier = Modifier.padding(start = 15.dp),
            horizontalArrangement = Arrangement.spacedBy(7.dp)
        ) {

            getChipData2().forEach {
                val isSelected = selectedChip2 == it
                Button(
                    shape = RoundedCornerShape(5.dp),
                    border = if (isSelected) null else BorderStroke(width = 1.dp, color = Silver),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isSelected) PrimaryPink else Color.White
                    ),
                    onClick = {
                        selectedChip2 = if (selectedChip2 == it) "" else it
                    }
                ) {
                    Text(
                        text = it,
                        style = TextStyle(
                            color = if (isSelected) Color.White else Color.Black,
                            platformStyle = PlatformTextStyle(includeFontPadding = false)

                        )
                    )
                }
            }

        }

        MSpacer(space = 10)

        Text(
            modifier = Modifier.padding(start = 15.dp),
            text = "Event Type", style = TextStyle(
                color = Color.Black,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp
            )
        )

        FlowRow(
            modifier = Modifier.padding(start = 15.dp),
            horizontalArrangement = Arrangement.spacedBy(7.dp),
            verticalArrangement = Arrangement.spacedBy(7.dp)
        ) {

            getChipData3().forEach {
                val isSelected = selectedChip3 == it
                Button(
                    shape = RoundedCornerShape(5.dp),
                    border = if (isSelected) null else BorderStroke(width = 1.dp, color = Silver),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isSelected) PrimaryPink else Color.White
                    ),
                    onClick = {
                        if (selectedChip3 == it) selectedChip3 = "" else selectedChip3 = it
                    }
                ) {
                    Text(
                        text = it,
                        style = TextStyle(
                            color = if (isSelected) Color.White else Color.Black,
                            platformStyle = PlatformTextStyle(includeFontPadding = false)

                        )
                    )
                }
            }

        }

        MSpacer(space = 10)

        Text(
            modifier = Modifier.padding(start = 15.dp),
            text = "Purpose", style = TextStyle(
                color = Color.Black,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp
            )
        )

        FlowRow(
            modifier = Modifier.padding(start = 15.dp),
            horizontalArrangement = Arrangement.spacedBy(7.dp),
            verticalArrangement = Arrangement.spacedBy(7.dp)
        ) {

            getChipData4().forEach {
                val isSelected = selectedChip4 == it
                Button(
                    shape = RoundedCornerShape(5.dp),
                    border = if (isSelected) null else BorderStroke(width = 1.dp, color = Silver),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isSelected) PrimaryPink else Color.White
                    ),
                    onClick = {
                        if (selectedChip4 == it) selectedChip4 = "" else selectedChip4 = it
                    }
                ) {
                    Text(
                        text = it,
                        style = TextStyle(
                            color = if (isSelected) Color.White else Color.Black,
                            platformStyle = PlatformTextStyle(includeFontPadding = false)

                        )
                    )
                }
            }

        }

    }

}