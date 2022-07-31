package com.example.test

import java.io.*
import java.util.*
import kotlin.collections.HashMap


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val str = br.readLine()
    val queue: Queue<Int> = LinkedList()

    for (i in 1..str.length) {
        queue.add(i)
    }

    val map = HashMap<String, Int>()

    while (!queue.isEmpty()) {
        val str_length = queue.poll()

        for (i in 0..str.length - str_length) {
            val key = str.substring(i, i + str_length)
            if (map.containsKey(key)) continue
            else {
                map.put(key, 1)
            }
        }
    }

    println(map.size)

}












