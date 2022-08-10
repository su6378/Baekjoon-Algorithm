package com.ssafy.algorithm

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt()
    val M = sc.nextInt()
    val index = IntArray(N + 1)
    index[0] = 0

    for (i in 1..N) {
        index[i] = index[i - 1] + sc.nextInt()
    }
    for (i in 0 until M) {
        val firstIndex = sc.nextInt()
        val lastIndex = sc.nextInt()
        println(index[lastIndex] - index[firstIndex - 1])
    }
}
