package com.ssafy.algorithm

import java.io.*
import java.util.*
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var token = StringTokenizer(br.readLine())

    val N = token.nextToken().toInt()
    val K = token.nextToken().toInt()

    val arr = IntArray(N)

    token = StringTokenizer(br.readLine())

    for (i in 0 until N) {
        arr[i] = token.nextToken().toInt()
    }

    var sum = 0
    var max = Int.MIN_VALUE
    for (i in 0 until N - K+1) {
        sum = 0
        for (j in i until i + K) {
            sum += arr[j]
        }
        max = max(max, sum)
    }

    println(max)
}

