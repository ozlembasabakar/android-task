package com.example.ozlembasabakar.model

import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
data class TasksItem(
    @PrimaryKey val BusinessUnitKey: String,
    val businessUnit: String?,
    val colorCode: String?,
    val description: String?,
    val isAvailableInTimeTrackingKioskMode: Boolean?,
    val parentTaskID: String?,
    val preplanningBoardQuickSelect: String?,
    val sort: String?,
    val task: String?,
    val title: String?,
    val wageType: String?,
    val workingTime: String?,
)