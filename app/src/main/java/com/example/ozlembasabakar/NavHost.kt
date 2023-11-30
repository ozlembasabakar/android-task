package com.example.ozlembasabakar

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ozlembasabakar.designsystem.components.BarcodeScanner
import com.example.ozlembasabakar.feature.tasksscreen.TasksScreen
import com.example.ozlembasabakar.feature.tasksscreen.TasksScreenViewModel

@Composable
fun NavHost() {

    val navController = rememberNavController()

    val tasksScreenViewModel: TasksScreenViewModel = hiltViewModel()
    val searchResults by tasksScreenViewModel.searchResults.collectAsStateWithLifecycle()
    val isRefreshing by tasksScreenViewModel.isRefreshing.collectAsStateWithLifecycle()

    val context = LocalContext.current

    var barcodeTextResult by remember {
        mutableStateOf("")
    }

    var hasCameraPermission by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
        )
    }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { granted ->
            hasCameraPermission = granted
            if (granted) {
                tasksScreenViewModel.startScanning { result ->
                    barcodeTextResult = result.barcodeFormatString + ": " + result.barcodeText
                }
                tasksScreenViewModel.cameraEnhancer.open()
            }
        }
    )

    NavHost(
        modifier = Modifier,
        navController = navController,
        startDestination = Screen.TaskListScreen.route
    ) {

        composable(Screen.TaskListScreen.route) {
            TasksScreen(
                value = tasksScreenViewModel.searchQuery,
                onValueChange = {
                    tasksScreenViewModel.onSearchQueryChange(it)
                },
                searchResults = searchResults,
                isRefreshing = isRefreshing,
                onRefresh = {
                    tasksScreenViewModel.insertTaskList()
                },
                onClick = {
                    navController.navigate(Screen.BarcodeScanScreen.route)
                }
            )
        }

        composable(Screen.BarcodeScanScreen.route) {

            LaunchedEffect(key1 = true) {
                tasksScreenViewModel.setScanner()
                launcher.launch(Manifest.permission.CAMERA)
            }

            BarcodeScanner(
                barcodeTextResult = barcodeTextResult,
                tasksScreenViewModel = tasksScreenViewModel
            )
        }
    }
}

sealed class Screen(
    val route: String,
) {
    object TaskListScreen : Screen("TaskListScreen")
    object BarcodeScanScreen : Screen("BarcodeScanScreen")
}