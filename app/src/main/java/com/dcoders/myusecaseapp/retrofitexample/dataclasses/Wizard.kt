package com.dcoders.myusecaseapp.retrofitexample.dataclasses

data class Wizard(

    val elixers: List<WizardElixir>?,
    val id: String,
    val firstname: String?,
    val lastName:String?
)

data class WizardElixir(
    val id: String,
    val name: String?
)
