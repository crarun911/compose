package com.dcoders.myusecaseapp.playground.usecases

import com.dcoders.myusecaseapp.playground.domain.Todo
import com.dcoders.myusecaseapp.playground.room.TodoEntity
import com.dcoders.myusecaseapp.playground.room.TodoRepository
import javax.inject.Inject

class UpdateTodoUseCase @Inject constructor(private val repository: TodoRepository) {
    suspend operator fun invoke(todo: Todo) = repository.updateTodo(todo )
}