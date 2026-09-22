package com.dcoders.myusecaseapp.playground.usecases

import com.dcoders.myusecaseapp.playground.domain.Todo
import com.dcoders.myusecaseapp.playground.room.TodoEntity
import com.dcoders.myusecaseapp.playground.room.TodoRepository

class InsertTodoUseCase(private val repository: TodoRepository) {
    suspend operator fun invoke(title: String) = repository.insertTodo(title )
}