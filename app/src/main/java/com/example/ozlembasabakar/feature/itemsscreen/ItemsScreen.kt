package com.example.ozlembasabakar.feature.itemsscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ozlembasabakar.designsystem.components.ItemCardList
import com.example.ozlembasabakar.designsystem.components.SearchBar
import com.example.ozlembasabakar.designsystem.theme.ItemCardListSpacerHeight
import com.example.ozlembasabakar.designsystem.theme.ItemsScreenHorizontalPadding

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemsScreen() {

    val itemsScreenViewModel: ItemsScreenViewModel = hiltViewModel()
    val searchResults by itemsScreenViewModel.searchResults.collectAsStateWithLifecycle()

    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface,
        content =
        {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = ItemsScreenHorizontalPadding)
            ) {
                Spacer(
                    modifier = Modifier
                        .height(ItemCardListSpacerHeight)
                        .fillMaxWidth()
                )
                SearchBar(
                    value = itemsScreenViewModel.searchQuery,
                    onValueChange = { itemsScreenViewModel.onSearchQueryChange(it) }
                )
                ItemCardList(
                    items = searchResults
                )
            }
        }
    )
}

@Preview
@Composable
fun ItemsScreenPreview() {
    ItemsScreen()
}