package com.example.test

import java.io.*
import java.util.*

var N = 0
lateinit var consult: Array<IntArray>
var max = Int.MIN_VALUE


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    N = br.readLine().toInt()

    consult = Array(N + 1) { IntArray(2) }

    for (i in 1..N) {
        val token = StringTokenizer(br.readLine())
        consult[i][0] = token.nextToken().toInt()
        consult[i][1] = token.nextToken().toInt()
    }

    for (i in 1..N) {
        combination(i, 0)
    }


    println(max)
}

fun combination(day: Int, sum: Int) {
    val T = consult[day][0]
    val P = consult[day][1]
    if (day + T > N + 1) {
        max = Math.max(max, sum)
        return
    } else if (day + T == N + 1) {
        max = Math.max(max, sum + P)
        return
    }
    for (i in day + T..N) {
        combination(i, sum + P)
    }
}












