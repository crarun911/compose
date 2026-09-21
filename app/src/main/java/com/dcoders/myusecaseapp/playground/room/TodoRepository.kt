package com.dcoders.myusecaseapp.playground.room

import kotlinx.coroutines.flow.Flow

class TodoRepository(val dao: TodoDao) {


    fun getAllTodo(): Flow<List<TodoEntity>> {
         return dao.getAllDao()
    }

    suspend fun insertTodo(todoEntity: TodoEntity){
        dao.insertToDo(todoEntity =todoEntity )
    }
    suspend fun updateTodo(todoEntity: TodoEntity){
        dao.updateToDo(todoEntity.copy(isDone = !todoEntity.isDone) )
    }
    suspend fun deleteTodo(todoEntity: TodoEntity){
        dao.deleteToDo(todoEntity =todoEntity )
    }
}