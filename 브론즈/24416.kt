package com.example.test

import java.io.*

var cnt = 0
var dpCnt = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine()!!.toInt()

    fib(N)
    fibonacci(N)
    println("$cnt $dpCnt")
}

fun fib(n: Int): Int {
    return if (n == 1 || n == 2) {
        cnt++
        1
    } else fib(n - 1) + fib(n - 2)
}

fun fibonacci(n: Int): Int {
    val f = IntArray(n + 1)
    f[1] = 1
    f[2] = 1
    for (i in 3..n) {
        f[i] = f[i - 1] + f[i - 2]
        dpCnt++
    }
    return f[n]
}









