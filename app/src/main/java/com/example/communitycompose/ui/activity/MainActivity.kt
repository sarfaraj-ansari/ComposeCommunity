package com.example.communitycompose.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.communitycompose.ui.screens.MainScreen
import com.example.communitycompose.ui.theme.CommunityComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CommunityComposeTheme {
                MainScreen()
            }
        }
    }
}