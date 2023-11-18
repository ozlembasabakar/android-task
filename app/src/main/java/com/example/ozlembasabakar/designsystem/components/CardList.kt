package com.example.ozlembasabakar.designsystem.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.ozlembasabakar.designsystem.theme.ItemCardListVerticalArrangementPadding
import com.example.ozlembasabakar.designsystem.theme.ItemCardListVerticalPadding
import com.example.ozlembasabakar.designsystem.theme.OzlemBasabakarTheme
import com.example.ozlembasabakar.model.Item

@Composable
fun ItemCardList(modifier: Modifier = Modifier, items: List<Item>) {

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(
                vertical = ItemCardListVerticalPadding
            ),
        verticalArrangement = Arrangement.spacedBy(ItemCardListVerticalArrangementPadding)
    ) {
        items(items) { item ->
            ItemCard(item)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    OzlemBasabakarTheme {

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
        )
        ItemCardList(Modifier, items)
    }
}