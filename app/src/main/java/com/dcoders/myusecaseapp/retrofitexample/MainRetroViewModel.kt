package com.dcoders.myusecaseapp.retrofitexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainRetroViewModel: ViewModel() {
    private val _harrypotter= MutableLiveData("No value")
    val harryPotterData: LiveData<String> get() = _harrypotter
}