package com.example.ozlembasabakar.data

import androidx.compose.ui.graphics.Color
import com.example.ozlembasabakar.model.Item
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class LocalDatasource @Inject constructor() {
    val items = flowOf(
        listOf(
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
                "I am a the fourth title",
                "I am the fourth task",
                "I am the fourth description",
                Color.Red
            ),
            Item(
                "I am the fifth title",
                "I am the fifth task",
                "I am the fifth description",
                Color.Blue
            ),
            Item(
                "I am a the sixth title",
                "I am the sixth task",
                "I am the sixth description",
                Color.LightGray
            ),
        )
    )
}