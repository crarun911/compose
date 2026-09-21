package com.dcoders.myusecaseapp.playground.room

import androidx.room3.Dao
import androidx.room3.Delete
import androidx.room3.Insert
import androidx.room3.OnConflictStrategy.Companion.REPLACE
import androidx.room3.Query
import androidx.room3.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface TodoDao {

    @Query("select * from tableTodo")
    fun getAllDao(): Flow<List<TodoEntity>>

    @Insert(onConflict = REPLACE)
    suspend fun insertToDo(todoEntity: TodoEntity)

    @Update
    suspend fun updateToDo(todoEntity: TodoEntity)

    @Delete
    suspend fun deleteToDo(todoEntity: TodoEntity)
}