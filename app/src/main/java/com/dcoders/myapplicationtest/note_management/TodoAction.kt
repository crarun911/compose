package com.dcoders.myapplicationtest.note_management

sealed interface TodoAction {

    data class TitleChanged(val newTitle: String): TodoAction
    data class  DescriptionChanged(val newDescription: String): TodoAction
    data class CompleteChanged(val id: Int,val newComplete: Boolean) : TodoAction

}



