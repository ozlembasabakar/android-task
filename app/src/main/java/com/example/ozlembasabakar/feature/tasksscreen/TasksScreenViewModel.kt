package com.example.ozlembasabakar.feature.tasksscreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ozlembasabakar.data.TaskRepository
import com.example.ozlembasabakar.model.Task
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TasksScreenViewModel @Inject constructor(
    private val taskRepository: TaskRepository,
) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            taskRepository.insertTaskList()

            //Log.d("ozlemwashere", taskRepository.getAllTaskItem().toString())
            //Log.d("ozlemwashere", "result: $result")
            //Log.d("ozlemwashere", "colorCode: ${result.first()}")
        }
    }

    var searchQuery by mutableStateOf("")
        private set

    val searchResults: StateFlow<List<Task>> =
        snapshotFlow { searchQuery }
            .combine(taskRepository.getAllTaskFromDatabase()) { searchQuery, tasks ->
                when {
                    searchQuery.isNotEmpty() -> tasks.filter { task ->
                        task.title.contains(searchQuery, ignoreCase = true) ||
                                task.task.contains(searchQuery, ignoreCase = true) ||
                                task.description.contains(searchQuery, ignoreCase = true)
                    }

                    else -> tasks
                }
            }.stateIn(
                scope = viewModelScope,
                initialValue = emptyList(),
                started = SharingStarted.WhileSubscribed(5_000)
            )

    fun onSearchQueryChange(newQuery: String) {
        searchQuery = newQuery
    }
}