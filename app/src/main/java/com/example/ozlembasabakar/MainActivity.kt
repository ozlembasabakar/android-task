package com.example.ozlembasabakar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.example.ozlembasabakar.designsystem.theme.OzlemBasabakarTheme
import com.example.ozlembasabakar.feature.itemsscreen.ItemsScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(
            window,
            false
        )

        setContent {
            OzlemBasabakarTheme {
                ItemsScreen()
            }
        }
    }
}