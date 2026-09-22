package com.dcoders.myusecaseapp.playground.room

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dcoders.myusecaseapp.playground.TodoAppContainer

class TodoViewModelFactory(
    private val application: Application,
    private val container: TodoAppContainer
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return TodoViewModel(application,
            container.todoGetUseCase,
            container.todoInsertUseCase,
            container.todoUpdateUseCase,
            container.todoDeleteUseCase,
            ) as T
    }
}