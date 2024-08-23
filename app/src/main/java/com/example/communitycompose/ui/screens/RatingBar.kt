package com.example.communitycompose.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.communitycompose.ui.theme.Platinum
import com.example.communitycompose.ui.theme.TextColorTime

@Preview
@Composable
fun RatingBar(
    numOfStars: Int = 5,
    rating: Float = 3.0f,
    onRatingChanged: (Int) -> Unit = {}
) {

    val isHalfStar = rating % 1 != 0f
    Row {
        (0..<numOfStars).forEach { i ->
            val icon =
                if (i < rating) Icons.Default.Star /*else if(isHalfStar) Icons.Default.StarHalf*/ else Icons.Outlined.Star
            val tint = if (i < rating) Color.Yellow else TextColorTime
            Icon(
                modifier = Modifier
                    .size(20.dp)
                    .clickable { onRatingChanged.invoke(i+1) },
                imageVector = Icons.Default.Star,
                contentDescription = null,
                tint = tint
            )
        }
    }

}