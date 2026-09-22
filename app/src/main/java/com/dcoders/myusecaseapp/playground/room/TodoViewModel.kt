package com.dcoders.myusecaseapp.playground.room

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.dcoders.myusecaseapp.playground.domain.Todo
import com.dcoders.myusecaseapp.playground.usecases.DeleteTodoUseCase
import com.dcoders.myusecaseapp.playground.usecases.GetTodoUseCase
import com.dcoders.myusecaseapp.playground.usecases.InsertTodoUseCase
import com.dcoders.myusecaseapp.playground.usecases.UpdateTodoUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlin.collections.emptyList

class TodoViewModel(application: Application,
    private val todoGetTodoUseCase: GetTodoUseCase,
                    private val todoInsertTodoUseCase: InsertTodoUseCase,
                    private val todoUpdateUseCase: UpdateTodoUseCase,
                    private val todoDeleteUseCase: DeleteTodoUseCase,
): AndroidViewModel(application = application) {


    var todos: StateFlow<List<Todo>> = todoGetTodoUseCase.invoke()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )


    fun createTodo(title: String){
        viewModelScope.launch {
            todoInsertTodoUseCase.invoke(title)
        }
    }
    fun updateTodo(todo: Todo){
        viewModelScope.launch {
            todoUpdateUseCase.invoke(todo)
        }
    }
    fun deleteTodo(todo: Todo){
        viewModelScope.launch {
            todoDeleteUseCase.invoke(todo)
        }
    }


}