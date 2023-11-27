package com.example.ozlembasabakar.designsystem.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.ozlembasabakar.designsystem.theme.PullToRefreshAnimationPadding
import com.example.ozlembasabakar.designsystem.theme.PullToRefreshAnimationSize

@Composable
fun PullToRefreshAnimation(
    modifier: Modifier = Modifier,
    isRefreshing: () -> Boolean,
    willRefresh: () -> Boolean,
    offsetProgress: () -> Float,
) {
    Box(
        modifier = modifier
            .size(PullToRefreshAnimationSize)
            .padding(PullToRefreshAnimationPadding),
        contentAlignment = Alignment.Center
    ) {
        PullToRefreshIcon(
            isRefreshing = isRefreshing(),
            willRefresh = willRefresh(),
            offsetProgress = offsetProgress(),
            shape = CircleShape,
            color = MaterialTheme.colorScheme.onSurface,
        )
    }
}