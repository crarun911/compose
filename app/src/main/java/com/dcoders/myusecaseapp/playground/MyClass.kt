package com.dcoders.myusecaseapp.playground

import android.app.Application

class MyClass: Application() {
    val container by lazy { TodoAppContainer(application =this) }
}