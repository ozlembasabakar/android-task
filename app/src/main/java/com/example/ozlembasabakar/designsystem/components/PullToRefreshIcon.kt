package com.example.ozlembasabakar.designsystem.components

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import com.example.ozlembasabakar.designsystem.icons.AppIcons
import com.example.ozlembasabakar.designsystem.theme.PullToRefreshAnimationPadding


@Composable
fun PullToRefreshIcon(
    modifier: Modifier = Modifier,
    isRefreshing: Boolean,
    willRefresh: Boolean,
    offsetProgress: Float,
    shape: Shape = CircleShape,
    color: Color,
) {

    val scale by animateFloatAsState(
        targetValue = if (willRefresh) 1f else .8f,
        animationSpec = spring(
            dampingRatio = Spring.StiffnessHigh
        ), label = ""
    )
    val rotateTransition = rememberInfiniteTransition(label = "")

    val rotation by when {
        isRefreshing -> rotateTransition.animateFloat(
            initialValue = 0f,
            targetValue = 360f,
            animationSpec = infiniteRepeatable(
                animation = tween(1000),
                repeatMode = RepeatMode.Restart,
            ), label = ""
        )

        else -> remember { mutableFloatStateOf(0f) }
    }

    Box(
        modifier = modifier
            .scale(scale)
            .clip(shape)
    ) {
        Box(
            modifier = Modifier
                .rotate(rotation)
                .align(Alignment.Center)
                .scale(offsetProgress * 1.5f)
                .fillMaxSize()
                .background(color = color)
        )

        Box(
            modifier = Modifier
                .rotate(rotation)
                .align(Alignment.Center)
                .scale(offsetProgress)
                .clip(shape)
                .background(color = color)
                .fillMaxSize()
        ) {
            Icon(
                painter = painterResource(id = AppIcons.SwipeRefreshLoadingArrow),
                contentDescription = null,
                modifier = Modifier
                    .padding(PullToRefreshAnimationPadding)
                    .rotate(rotation)
                    .align(Alignment.Center)
                    .scale(offsetProgress)
                    .clip(shape)
                    .background(color = color),
                tint = MaterialTheme.colorScheme.surface
            )
        }
    }
}