package com.example.ozlembasabakar.designsystem.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.ozlembasabakar.designsystem.theme.Typography


@Composable
fun BarcodeText(text: String) {
    Text(
        text = text,
        style = Typography.labelLarge
    )
}