package com.example.test

import java.io.*
import java.util.*
import kotlin.collections.HashMap

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val token = StringTokenizer(br.readLine())
    val n = token.nextToken().toInt()
    val m = token.nextToken().toInt()

    val n_map = HashMap<String, Int>()
    for (i in 0 until n) {
        val n_str = br.readLine().toString()
        n_map.put(n_str, 1)
    }
    var count = 0
    for (i in 0 until m) {
        val m_str = br.readLine().toString()
        if (n_map.get(m_str) != null) count++

    }
    println(count)
}

