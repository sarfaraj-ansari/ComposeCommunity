package com.example.communitycompose.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.communitycompose.R

val poppinsFontFamily = FontFamily(
    Font(R.font.poppins_medium),
    Font(R.font.poppins_bold),
    Font(R.font.poppins_semibold),
    Font(R.font.poppins_regular)
)

val Typography = Typography(
    headlineLarge = TextStyle(
        color = Black,
        fontWeight = FontWeight.SemiBold,
        fontFamily = poppinsFontFamily,
        fontSize = 22.sp
    ),

    headlineMedium = TextStyle(
        color = Black,
        fontWeight = FontWeight.SemiBold,
        fontFamily = poppinsFontFamily,
        fontSize = 16.sp
    ),

    headlineSmall = TextStyle(
        color = Black,
        fontWeight = FontWeight.SemiBold,
        fontFamily = poppinsFontFamily,
        fontSize = 10.sp
    ),

    titleLarge = TextStyle(
        color = Black,
        fontWeight = FontWeight.Medium,
        fontFamily = poppinsFontFamily,
        fontSize = 22.sp
    ),
    titleMedium = TextStyle(
        color = Black,
        fontWeight = FontWeight.Medium,
        fontFamily = poppinsFontFamily,
        fontSize = 16.sp
    ),
    titleSmall = TextStyle(
        color = Black,
        fontWeight = FontWeight.Medium,
        fontFamily = poppinsFontFamily,
        fontSize = 10.sp
    ),

    labelLarge = TextStyle(
        color = Silver,
        fontWeight = FontWeight.Normal,
        fontFamily = poppinsFontFamily,
        fontSize = 20.sp
    ),
    labelMedium = TextStyle(
        color = Silver,
        fontWeight = FontWeight.Normal,
        fontFamily = poppinsFontFamily,
        fontSize = 15.sp
    ),
    labelSmall = TextStyle(
        color = Silver,
        fontWeight = FontWeight.Normal,
        fontFamily = poppinsFontFamily,
        fontSize = 10.sp
    ),


)