package com.example.administrator.mycontrol.kotlin

/**
 * Created by phantom on 2017/7/18.
 */

fun main(args: Array<String>) {
    while (true) {
        try {
            println("xxxx 3 + 4 ")
            val input = readLine() ?: break
            val splits = input?.trim().split(" ")
            val a = splits[0].toDouble()
            val op = splits[1]
            val b = splits[2].toDouble()
            println("$a  $op $b = ${TT(op)(a,b)}")
        } catch (e: NumberFormatException) {

        }
    }
}

class TT(op: String) {
    val opfun: (left: Double, right: Double) -> Double

    init {
        opfun = when (op) {
            "+" -> { l, r -> l + r }
            "-" -> { l, r -> l - r }
            "*" -> { l, r -> l * r }
            "/" -> { l, r -> l / r }
            "%" -> { l, r -> l % r }
            else -> {
                throw UnsupportedOperationException(op)
            }
        }
    }
    operator fun invoke(left: Double ,right: Double):Double{
        return opfun(left,right)
    }
}