package com.dcoders.myusecaseapp.playground.room

import com.dcoders.myusecaseapp.playground.domain.Todo
import com.dcoders.myusecaseapp.playground.remote.TodoRemoteDataSource
import com.dcoders.myusecaseapp.playground.util.toDmain
import com.dcoders.myusecaseapp.playground.util.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import kotlin.time.Clock

class TodoRepository @Inject constructor(
    private val dao: TodoDao,
    private val remoteDataSource: TodoRemoteDataSource
) {


    fun getAllTodo(): Flow<List<Todo>> {
        return dao.getAllDao().map { entities -> entities.map { it.toDmain() } }
    }

    suspend fun insertTodo(title: String) {
        dao.insertToDo(Todo(id = 0, title = title, isDone = false, updatedAt = System.currentTimeMillis()).toEntity())
    }

    suspend fun updateTodo(todo: Todo) {
        dao.updateToDo(todo.copy(isDone = !todo.isDone, updatedAt = System.currentTimeMillis()).toEntity())
    }

    suspend fun deleteTodo(todo: Todo) {
        dao.deleteToDo(todo.toEntity())
    }
    suspend fun syncFromRemote() {
        val remoteTodos = remoteDataSource.fetchTodos()
        remoteTodos.forEach { todo ->
            dao.insertToDo(todo.toEntity())
        }
    }
}