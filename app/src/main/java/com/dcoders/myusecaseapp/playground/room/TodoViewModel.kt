package com.dcoders.myusecaseapp.playground.room

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlin.collections.emptyList

class TodoViewModel(application: Application): AndroidViewModel(application = application) {

    val dao= TodoDatatbase.getInstance(application).todoDao()

    var todos by mutableStateOf<List<TodoEntity>>(emptyList())
        private set
    init {
        refresh()
    }

    fun refresh(){
        viewModelScope.launch {
            todos=dao.getAllDao()
        }
    }
    fun createTodo(title: String){
        viewModelScope.launch {
            dao.insertToDo(TodoEntity(title = title))
            refresh()
        }
    }
    fun updateTodo(todoEntity: TodoEntity){
        viewModelScope.launch {
            dao.updateToDo(todoEntity.copy(
                isDone = !todoEntity.isDone
            ))
            refresh()
        }
    }
    fun deleteTodo(todoEntity: TodoEntity){
        viewModelScope.launch {
            dao.deleteToDo(todoEntity)
            refresh()
        }
    }


}