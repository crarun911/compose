package com.dcoders.myusecaseapp.retrofitexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dcoders.myusecaseapp.retrofitexample.dataclasses.RetrofitClient
import kotlinx.coroutines.launch

class MainRetroViewModel: ViewModel() {
    private var _harrypotter= MutableLiveData("No value")
    val harryPotterData: LiveData<String> get() = _harrypotter

    init {
        viewModelScope.launch {
            getUserData()
        }
    }

    suspend fun getUserData(){
        _harrypotter.value= RetrofitClient.wizardWorldApiService.getHouses().toString()
    }
}