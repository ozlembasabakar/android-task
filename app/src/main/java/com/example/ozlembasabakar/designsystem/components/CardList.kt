package com.example.ozlembasabakar.designsystem.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ozlembasabakar.designsystem.theme.OzlemBasabakarTheme
import com.example.ozlembasabakar.designsystem.theme.TaskCardListVerticalArrangementPadding
import com.example.ozlembasabakar.designsystem.theme.TaskCardListVerticalPadding
import com.example.ozlembasabakar.model.Task

@Composable
fun TaskCardList(modifier: Modifier = Modifier, taskList: List<Task>) {

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(
                vertical = TaskCardListVerticalPadding
            ),
        verticalArrangement = Arrangement.spacedBy(TaskCardListVerticalArrangementPadding)
    ) {
        items(taskList) { task ->
            TaskCard(task)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    OzlemBasabakarTheme {

        val tasks = listOf<Task>(
            Task(
                "0",
                "I am a the first title",
                "I am the first task",
                "I am the first description",
                "Color.Cyan"
            )
        )
        TaskCardList(Modifier, tasks)
    }
}