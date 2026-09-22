package com.dcoders.myusecaseapp.playground.usecases

import com.dcoders.myusecaseapp.playground.domain.Todo
import com.dcoders.myusecaseapp.playground.room.TodoEntity
import com.dcoders.myusecaseapp.playground.room.TodoRepository

class UpdateTodoUseCase(private val repository: TodoRepository) {
    suspend operator fun invoke(todo: Todo) = repository.updateTodo(todo )
}