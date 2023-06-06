package com.example.test

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val graph = Array(101) { IntArray(101) }
    var count = 0

    for (i in 0..3) {
        val token = StringTokenizer(br.readLine())
        val x1 = token.nextToken().toInt()
        val y1 = token.nextToken().toInt()
        val x2 = token.nextToken().toInt()
        val y2 = token.nextToken().toInt()

        for (j in 100 - y2 + 1..100 - y1) {
            for (k in x1 until x2) {
                graph[j][k] = 1
            }
        }
    }

    for (j in graph.indices) {
        for (k in graph.indices) {
            if (graph[j][k] == 1) count++
        }
    }
    println(count)
}













