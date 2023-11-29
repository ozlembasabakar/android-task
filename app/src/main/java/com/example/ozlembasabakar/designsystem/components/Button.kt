package com.example.ozlembasabakar.designsystem.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.ozlembasabakar.designsystem.icons.AppIcons
import com.example.ozlembasabakar.designsystem.theme.OzlemBasabakarTheme

@Composable
fun Button(
    modifier: Modifier,
    onClick: () -> Unit,
    buttonIcon: Int,
) {
    Box(
        modifier = modifier
            .clickable(
                onClick = onClick,
                interactionSource = remember { MutableInteractionSource() },
                indication =
                rememberRipple(bounded = true),
            )
    ) {
        Icon(
            painter = painterResource(id = buttonIcon),
            contentDescription = "ButtonIcon"
        )
    }

}

@Composable
fun QrCodeScanButton(
    modifier: Modifier,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        buttonIcon = AppIcons.QrCodeScanIcon
    )
}

@Preview
@Composable
fun PreviewAddButton() {
    OzlemBasabakarTheme {
        QrCodeScanButton(modifier = Modifier, onClick = {})
    }
}