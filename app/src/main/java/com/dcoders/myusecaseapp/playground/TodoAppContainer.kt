package com.dcoders.myusecaseapp.playground

import android.app.Application
import com.dcoders.myusecaseapp.playground.room.TodoDatatbase
import com.dcoders.myusecaseapp.playground.room.TodoRepository

class TodoAppContainer(application: Application) {
    private val database= TodoDatatbase.getInstance(application)
    val todoRepository: TodoRepository by lazy { TodoRepository(database.todoDao()) }
}