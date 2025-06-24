package com.sylvieprojects.instaproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.sylvieprojects.instaproject.ui.theme.InstaProjectTheme
import com.sylvieprojects.instaproject.view.core.navigation.NavigationWrapper
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InstaProjectTheme {
                NavigationWrapper()
            }
        }
    }
}