package com.dcoders.myusecaseapp.playground.util

import com.dcoders.myusecaseapp.playground.domain.Todo
import com.dcoders.myusecaseapp.playground.room.TodoEntity

fun TodoEntity.toDmain(): Todo = Todo(id = id, title = title, isDone = isDone)
fun Todo.toEntity(): TodoEntity= TodoEntity(id=id, title = title,isDone=isDone)