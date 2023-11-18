package com.example.ozlembasabakar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.ozlembasabakar.ui.theme.ItemCardListHorizontalPadding
import com.example.ozlembasabakar.ui.theme.ItemCardListVerticalArrangementPadding
import com.example.ozlembasabakar.ui.theme.ItemCardListVerticalPadding
import com.example.ozlembasabakar.ui.theme.ItemCardPadding
import com.example.ozlembasabakar.ui.theme.ItemCardVerticalArrangementPadding
import com.example.ozlembasabakar.ui.theme.OzlemBasabakarTheme
import com.example.ozlembasabakar.ui.theme.Shapes

@Composable
fun ItemCardList(modifier: Modifier = Modifier, items: List<Item>) {

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(
                horizontal = ItemCardListHorizontalPadding,
                vertical = ItemCardListVerticalPadding
            ),
        verticalArrangement = Arrangement.spacedBy(ItemCardListVerticalArrangementPadding)
    ) {
        items(items) { item ->
            ItemCard(item)
        }
    }
}

@Composable
fun ItemCard(item: Item) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(Shapes.small)
            .background(item.colorCode)
            .padding(ItemCardPadding),
        verticalArrangement = Arrangement.spacedBy(ItemCardVerticalArrangementPadding)
    ) {
        Text(text = item.title)
        Text(text = item.task)
        Text(text = item.description)
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