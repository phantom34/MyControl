package com.example.administrator.aasdasd

/**
 * Created by phantom on 2017/6/1.
 */


open class Animal

internal class Dog : Animal() {
    fun bark() {
        println("animal")
    }
}

var animal: Animal? = null

fun main(args: Array<String>) {
    if (animal is Dog) {
        //在这里你必须手动强转为Dog的对象
        (animal as Dog).bark()
    }
    println(1)
    var x: Int = 1
    println(x)
    for (x in 1..5 step 2) {
        println(x)

    }

}
