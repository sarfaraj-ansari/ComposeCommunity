package com.example.communitycompose.custom

import android.widget.Space
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MSpacer(space: Int) {
    Spacer(modifier = Modifier.padding(space.dp))
}