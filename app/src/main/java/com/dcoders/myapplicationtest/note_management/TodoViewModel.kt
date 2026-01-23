package com.dcoders.myapplicationtest.note_management

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TodoViewModel: ViewModel() {
    private val _state = MutableStateFlow(
        listOf(Todo(1,"",""),
            Todo(2,"",""))
    )
    val state = _state.asStateFlow()
    fun onAction(action: TodoAction){
        when(action){
            is TodoAction.CompleteChanged ->
                _state.update {
                    it.map {
                        if (it.id==action.id){
                            it.copy(isComplete = action.newComplete)
                        }else
                            it


                    }
                }
            is TodoAction.DescriptionChanged -> TODO()
            is TodoAction.TitleChanged -> TODO()
        }

    }

}