package com.example.ozlembasabakar.feature.itemsscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemsScreen() {
    val itemsScreenViewModel: ItemsScreenViewModel = hiltViewModel()
    val itemsState by itemsScreenViewModel.items.collectAsStateWithLifecycle()

    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface,
        content =
        {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                ItemCardList(
                    items = itemsState.items
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