package com.example.ozlembasabakar.feature.tasksscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ozlembasabakar.designsystem.components.PullToRefresh
import com.example.ozlembasabakar.designsystem.components.SearchBar
import com.example.ozlembasabakar.designsystem.components.TaskCardList
import com.example.ozlembasabakar.designsystem.theme.TasksScreenHorizontalPadding
import com.example.ozlembasabakar.model.Task

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun TasksScreen(
    onValueChange: (String) -> Unit,
    value: String,
    searchResults: List<Task>,
    onRefresh: () -> Unit,
    isRefreshing: Boolean,
) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = TasksScreenHorizontalPadding)
                .padding(innerPadding)
        ) {
            SearchBar(
                value = value,
                onValueChange = { onValueChange(it) }
            )
            PullToRefresh(
                isRefreshing = isRefreshing,
                onRefresh = onRefresh,
                content = {
                    TaskCardList(
                        taskList = searchResults
                    )
                }
            )
        }
    }
}

@Preview
@Composable
fun ItemsScreenPreview() {
    TasksScreen(
        {},
        "",
        listOf(),
        {},
        false
    )
}