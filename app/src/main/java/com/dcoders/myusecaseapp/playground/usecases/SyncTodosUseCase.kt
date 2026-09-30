package com.dcoders.myusecaseapp.playground.usecases

import com.dcoders.myusecaseapp.playground.room.TodoRepository
import javax.inject.Inject

class SyncTodosUseCase @Inject constructor(private val repository: TodoRepository) {
    suspend operator fun invoke() = repository.syncFromRemote()
}