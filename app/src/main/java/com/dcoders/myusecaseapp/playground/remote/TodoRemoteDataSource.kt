package com.dcoders.myusecaseapp.playground.remote

import com.dcoders.myusecaseapp.playground.domain.Todo


import kotlinx.coroutines.delay
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TodoRemoteDataSource @Inject constructor() {

    // Simulates a remote server's data, held in memory for this demo
    private val remoteTodos = mutableListOf(
        Todo(id = 1001, title = "Remote todo  server", isDone = false),
        Todo(id = 1002, title = "Remote todo from ", isDone = false),
        Todo(id = 1003, title = "Remote  from server", isDone = false),
        Todo(id = 1004, title = " todo from server", isDone = false),
        Todo(id = 1005, title = "Remote todo from serv", isDone = false)
    )

    suspend fun fetchTodos(): List<Todo> {
        delay(800) // simulate network latency
        return remoteTodos.toList()
    }

    suspend fun addTodo(title: String): Todo {
        delay(300)
        val newTodo = Todo(id = remoteTodos.size + 1001, title = title, isDone = false)
        remoteTodos.add(newTodo)
        return newTodo
    }
}