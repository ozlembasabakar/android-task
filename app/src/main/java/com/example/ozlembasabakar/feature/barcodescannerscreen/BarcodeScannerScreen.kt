package com.example.ozlembasabakar.feature.barcodescannerscreen

import android.content.Context
import android.content.ContextWrapper
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.dynamsoft.dce.CameraEnhancer
import com.dynamsoft.dce.DCECameraView
import com.example.ozlembasabakar.designsystem.components.BarcodeText
import com.example.ozlembasabakar.feature.tasksscreen.TasksScreenViewModel


@Composable
fun BarcodeScanScreen(
    tasksScreenViewModel: TasksScreenViewModel,
    barcodeTextResult: String,
) {

    AndroidView(
        factory = { context ->

            tasksScreenViewModel.cameraEnhancer = CameraEnhancer(context.findActivity())

            val cameraView = DCECameraView(context)
            cameraView.overlayVisible = true
            tasksScreenViewModel.cameraEnhancer.cameraView = cameraView
            cameraView
        }
    )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        BarcodeText(text = barcodeTextResult)
    }
}

fun Context.findActivity(): ComponentActivity? = when (this) {
    is ComponentActivity -> this
    is ContextWrapper -> baseContext.findActivity()
    else -> null
}