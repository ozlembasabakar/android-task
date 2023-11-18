package com.example.ozlembasabakar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import com.example.ozlembasabakar.designsystem.components.ItemCardList
import com.example.ozlembasabakar.designsystem.theme.OzlemBasabakarTheme
import com.example.ozlembasabakar.model.Item

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(
            window,
            false
        )

        setContent {
            OzlemBasabakarTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val items = listOf<Item>(
                        Item(
                            "I am a the first title",
                            "I am the first task",
                            "I am the first description",
                            Color.Cyan
                        ),
                        Item(
                            "I am the second title",
                            "I am the second task",
                            "I am the second description",
                            Color.Green
                        ),
                        Item(
                            "I am a the third title",
                            "I am the third task",
                            "I am the third description",
                            Color.Magenta
                        ),
                        Item(
                            "I am a the first title",
                            "I am the first task",
                            "I am the first description",
                            Color.Cyan
                        ),
                        Item(
                            "I am the second title",
                            "I am the second task",
                            "I am the second description",
                            Color.Green
                        ),
                        Item(
                            "I am a the third title",
                            "I am the third task",
                            "I am the third description",
                            Color.Magenta
                        ),
                        Item(
                            "I am a the first title",
                            "I am the first task",
                            "I am the first description",
                            Color.Cyan
                        ),
                        Item(
                            "I am the second title",
                            "I am the second task",
                            "I am the second description",
                            Color.Green
                        ),
                        Item(
                            "I am a the third title",
                            "I am the third task",
                            "I am the third description",
                            Color.Magenta
                        ),
                        Item(
                            "I am a the first title",
                            "I am the first task",
                            "I am the first description",
                            Color.Cyan
                        ),
                        Item(
                            "I am the second title",
                            "I am the second task",
                            "I am the second description",
                            Color.Green
                        ),
                        Item(
                            "I am a the third title",
                            "I am the third task",
                            "I am the third description",
                            Color.Magenta
                        ),
                    )
                    ItemCardList(items = items)
                }
            }
        }
    }
}