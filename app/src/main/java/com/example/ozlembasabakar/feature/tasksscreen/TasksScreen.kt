package com.example.ozlembasabakar.feature.tasksscreen

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ozlembasabakar.designsystem.components.SearchBar
import com.example.ozlembasabakar.designsystem.components.TaskCardList
import com.example.ozlembasabakar.designsystem.theme.TaskCardListSpacerHeight
import com.example.ozlembasabakar.designsystem.theme.TasksScreenHorizontalPadding
import com.example.ozlembasabakar.model.Task

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TasksScreen(
    onValueChange: (String) -> Unit,
    value: String,
    searchResults: List<Task>,
) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = TasksScreenHorizontalPadding)
        ) {
            Spacer(
                modifier = Modifier
                    .height(TaskCardListSpacerHeight)
                    .fillMaxWidth()
            )
            SearchBar(
                value = value,
                onValueChange = { onValueChange(it) }
            )
            TaskCardList(
                taskList = searchResults
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
        listOf()
    )
}