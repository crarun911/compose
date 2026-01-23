package com.dcoders.myapplicationtest.note_management

data class Todo(
    val id: Int = 0,
    val title: String="",
    val description: String? = null,
    val isComplete: Boolean = false
)
