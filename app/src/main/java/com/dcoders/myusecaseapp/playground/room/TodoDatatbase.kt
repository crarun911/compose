package com.dcoders.myusecaseapp.playground.room

import android.content.Context
import androidx.room3.Database
import androidx.room3.Room
import androidx.room3.RoomDatabase


@Database(entities = [TodoEntity::class], version = 1, exportSchema = false)
abstract class TodoDatatbase: RoomDatabase() {
    abstract fun todoDao(): TodoDao
    companion object {
        @Volatile
        private var INSTANCE: TodoDatatbase? = null

        fun getInstance(context: Context): TodoDatatbase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TodoDatatbase::class.java,
                    "todo_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}