package com.dcoders.myusecaseapp.playground.room

import com.dcoders.myusecaseapp.playground.domain.Todo
import com.dcoders.myusecaseapp.playground.util.toDmain
import com.dcoders.myusecaseapp.playground.util.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TodoRepository(val dao: TodoDao) {


    fun getAllTodo(): Flow<List<Todo>> {
         return dao.getAllDao().map { entities -> entities.map { it.toDmain() } }
    }

    suspend fun insertTodo(title: String){
        dao.insertToDo(Todo(id=0,title = title,isDone = false).toEntity() )
    }
    suspend fun updateTodo(todo: Todo){
        dao.updateToDo(todo.copy(isDone = !todo.isDone).toEntity() )
    }
    suspend fun deleteTodo(todo: Todo){
        dao.deleteToDo(todo.toEntity() )
    }
}