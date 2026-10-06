package com.dcoders.myusecaseapp.retrofitexample

import com.dcoders.myusecaseapp.retrofitexample.dataclasses.House
import retrofit2.http.GET

interface WizardWrorldApiService {

    @GET("/Houses")
    suspend fun getHouses(): List<House>


}