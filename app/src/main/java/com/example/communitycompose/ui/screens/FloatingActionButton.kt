package com.example.communitycompose.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun MFloatingActionButton(onFabClicked: () -> Unit, icon: Int, fabColor: Color) {

    FloatingActionButton(
        modifier = Modifier.size(50.dp),
        shape = CircleShape,
        containerColor = fabColor,
        onClick = onFabClicked
    ) {
        Image(painter = painterResource(id = icon), contentDescription = null)
    }

}