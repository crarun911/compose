package com.dcoders.playground.play


fun main() {

    funPrint(
        funcExe = {
            println("Hello there ")
            return@funPrint
        }
    ){
        println("Hello there from b ")

    }

    funPrint(funcExe = {println("Hello there1")}) { println("Hello there from b2") }

}

inline fun funPrint(crossinline funcExe: () -> Unit, noinline funB: () -> Unit) {
    funcExe.invoke()
    funB.invoke()
}
