package com.example.algorithm

import java.io.*
import java.util.*
import kotlin.collections.HashMap

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val token = StringTokenizer(br.readLine())
    val N = token.nextToken().toInt()
    val M = token.nextToken().toInt()
    var count = 0;
    val listen_see = HashMap<String, Int>()

    for (i in 1..N + M) {
        val key = br.readLine()
        if (listen_see.containsKey(key)) {
            listen_see.put(key, listen_see.get(key)!! + 1)
            count++
        } else listen_see.put(key, 1)
    }

    val sort_map = listen_see.toSortedMap()

    println(count)
    for ((key, value) in sort_map) {
        if (sort_map.getValue(key) > 1) {
            println(key)
        }
    }

    bw.flush()
    bw.close()
}


