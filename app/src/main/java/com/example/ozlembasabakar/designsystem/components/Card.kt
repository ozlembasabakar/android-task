package com.example.ozlembasabakar.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.core.graphics.toColorInt
import com.example.ozlembasabakar.designsystem.theme.OzlemBasabakarTheme
import com.example.ozlembasabakar.designsystem.theme.Shapes
import com.example.ozlembasabakar.designsystem.theme.TaskCardPadding
import com.example.ozlembasabakar.designsystem.theme.TaskCardVerticalArrangementPadding
import com.example.ozlembasabakar.model.Task

@Composable
fun Card(
    firstText: String,
    secondText: String,
    thirdText: String,
    background: Color,
    clip: CornerBasedShape,
    padding: Dp,
    verticalArrangementPadding: Dp,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(clip)
            .background(background)
            .padding(padding),
        verticalArrangement = Arrangement.spacedBy(verticalArrangementPadding)
    ) {
        Text(text = firstText)
        Text(text = secondText)
        Text(text = thirdText)
    }
}

@Composable
fun TaskCard(task: Task) {
    Card(
        firstText = task.title,
        secondText = task.task,
        thirdText = task.description,
        background = Color(task.colorCode.toColorInt()), //Color("#B00020".toColorInt()),
        clip = Shapes.small,
        padding = TaskCardPadding,
        verticalArrangementPadding = TaskCardVerticalArrangementPadding
    )
}

@Preview
@Composable
fun TaskCardPreview() {
    OzlemBasabakarTheme {
        val task = Task(
            "0",
            "I am a title",
            "I am a task",
            "I am a description",
            "Color.Cyan"
        )

        TaskCard(task = task)
    }
}