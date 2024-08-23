package com.example.communitycompose.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.communitycompose.ui.theme.BorderColor
import com.example.communitycompose.ui.theme.BorderColorTime
import com.example.communitycompose.ui.theme.Platinum
import com.example.communitycompose.ui.theme.Silver
import com.example.communitycompose.ui.theme.TextColorTime

@Preview
@Composable
fun ItemTime(time: String = "7:30AM") {

    Box(
        modifier = Modifier
            .height(35.dp)
            .width(80.dp)
            .padding(start = 3.dp, end = 3.dp)
            .border(width = 2.dp, color = BorderColorTime, shape = RoundedCornerShape(5.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(text = time, style = TextStyle(
            color = TextColorTime,
            fontSize = 10.sp
        ))
    }
}