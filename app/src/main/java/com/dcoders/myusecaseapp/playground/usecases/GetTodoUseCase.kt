package com.dcoders.myusecaseapp.playground.usecases

import com.dcoders.myusecaseapp.playground.domain.Todo
import com.dcoders.myusecaseapp.playground.room.TodoEntity
import com.dcoders.myusecaseapp.playground.room.TodoRepository
import kotlinx.coroutines.flow.Flow

class GetTodoUseCase(private val repository: TodoRepository) {
    operator fun invoke(): Flow<List<Todo>> = repository.getAllTodo()
}