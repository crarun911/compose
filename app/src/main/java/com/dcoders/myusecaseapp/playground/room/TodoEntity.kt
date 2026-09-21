package com.dcoders.myusecaseapp.playground.room

import androidx.room3.Entity
import androidx.room3.PrimaryKey


@Entity(tableName = "tableTodo")
data class TodoEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val  title: String,
    val isDone:Boolean=false
)