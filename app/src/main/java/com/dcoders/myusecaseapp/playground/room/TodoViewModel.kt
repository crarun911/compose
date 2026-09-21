package com.dcoders.myusecaseapp.playground.room

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlin.collections.emptyList

class TodoViewModel(application: Application,private val todoRepo: TodoRepository): AndroidViewModel(application = application) {


    var todos: StateFlow<List<TodoEntity>> = todoRepo.getAllTodo()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )


    fun createTodo(title: String){
        viewModelScope.launch {
            todoRepo.insertTodo(TodoEntity(title = title))
        }
    }
    fun updateTodo(todoEntity: TodoEntity){
        viewModelScope.launch {
            todoRepo.updateTodo(todoEntity)
        }
    }
    fun deleteTodo(todoEntity: TodoEntity){
        viewModelScope.launch {
            todoRepo.deleteTodo(todoEntity)
        }
    }


}