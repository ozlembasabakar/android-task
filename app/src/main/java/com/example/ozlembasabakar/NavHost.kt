package com.example.ozlembasabakar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ozlembasabakar.feature.tasksscreen.TasksScreen
import com.example.ozlembasabakar.feature.tasksscreen.TasksScreenViewModel

@Composable
fun NavHost() {

    val navController = rememberNavController()

    val tasksScreenViewModel: TasksScreenViewModel = hiltViewModel()
    val searchResults by tasksScreenViewModel.searchResults.collectAsStateWithLifecycle()
    val isRefreshing by tasksScreenViewModel.isRefreshing.collectAsStateWithLifecycle()

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
            )
        }
    }
}

sealed class Screen(
    val route: String,
) {
    object TaskListScreen : Screen("TaskListScreen")
}