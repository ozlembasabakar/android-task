package com.example.ozlembasabakar.feature.tasksscreen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dynamsoft.dbr.BarcodeReader
import com.dynamsoft.dbr.BarcodeReaderException
import com.dynamsoft.dbr.TextResult
import com.dynamsoft.dce.CameraEnhancer
import com.example.ozlembasabakar.data.TaskRepository
import com.example.ozlembasabakar.model.Task
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TasksScreenViewModel @Inject constructor(
    private val taskRepository: TaskRepository,
) : ViewModel() {

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> = _isRefreshing.asStateFlow()

    lateinit var cameraEnhancer: CameraEnhancer
    lateinit var barcodeReader: BarcodeReader

    init {
        insertTaskList()
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

    fun insertTaskList() {
        viewModelScope.launch(Dispatchers.IO) {
            _isRefreshing.value = true
            taskRepository.insertTaskList().onSuccess {
                Log.d("ozlem", "insertNewPostsInfoByCategory succeed")
            }.onFailure {
                Log.d("ozlem", "insertNewPostsInfoByCategory: $it")
            }
            _isRefreshing.value = false
        }
    }

    fun setScanner() {
        try {
            initializeLicense()
            inititializeDynamsoftBarcodeReader()
        } catch (e: Exception) {
            Log.d("ozlemwashere", e.message.toString())
        }
    }

    private fun initializeLicense() {
        BarcodeReader.initLicense(
            "DLS2eyJoYW5kc2hha2VDb2RlIjoiMjAwMDAxLTE2NDk4Mjk3OTI2MzUiLCJvcmdhbml6YXRpb25JRCI6IjIwMDAwMSIsInNlc3Npb25QYXNzd29yZCI6IndTcGR6Vm05WDJrcEQ5YUoifQ=="
        ) { isSuccess, error ->
            if (!isSuccess) {
                Log.d("ozlemwashere", error.printStackTrace().toString())
            } else {
                Log.d("ozlemwashere", "License initialized")
            }
        }
    }

    private fun inititializeDynamsoftBarcodeReader() {
        try {
            barcodeReader = BarcodeReader()
            barcodeReader.setCameraEnhancer(cameraEnhancer)
        } catch (e: BarcodeReaderException) {
            e.printStackTrace()
        }
    }

    fun startScanning(scanned: (TextResult) -> Unit) {
        try {
            barcodeReader.setTextResultListener { id, imageData, textResults ->
                if (textResults.isNotEmpty()) {
                    scanned(textResults[0])
                }
            }
            barcodeReader.startScanning()
        } catch (e: BarcodeReaderException) {
            e.printStackTrace()
        }
    }
}