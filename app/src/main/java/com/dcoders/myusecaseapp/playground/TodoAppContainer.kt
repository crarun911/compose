package com.dcoders.myusecaseapp.playground

import android.app.Application
import com.dcoders.myusecaseapp.playground.room.TodoDatatbase
import com.dcoders.myusecaseapp.playground.room.TodoRepository
import com.dcoders.myusecaseapp.playground.usecases.DeleteTodoUseCase
import com.dcoders.myusecaseapp.playground.usecases.GetTodoUseCase
import com.dcoders.myusecaseapp.playground.usecases.InsertTodoUseCase
import com.dcoders.myusecaseapp.playground.usecases.UpdateTodoUseCase

class TodoAppContainer(application: Application) {
    private val database= TodoDatatbase.getInstance(application)
    val todoRepository: TodoRepository by lazy { TodoRepository(database.todoDao())}
        val todoGetUseCase by lazy { GetTodoUseCase(todoRepository) }
        val todoUpdateUseCase by lazy { UpdateTodoUseCase(todoRepository) }
        val todoInsertUseCase by lazy { InsertTodoUseCase(todoRepository) }
        val todoDeleteUseCase by lazy { DeleteTodoUseCase(todoRepository) }

}