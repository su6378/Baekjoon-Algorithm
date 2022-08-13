package com.example.test

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var count = 0
var visited = BooleanArray(1000000001)


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val token = StringTokenizer(br.readLine())

    val A = token.nextToken().toLong()
    val B = token.nextToken().toLong()

    bfs(A, B)

    println(count)
}

fun bfs(A: Long, B: Long) {
    val current: Queue<Long> = LinkedList()
    current.add(A)
    visited[A.toInt()] = true
    while (!current.isEmpty()) {
        val cSize = current.size
        for (i in 0 until cSize) {
            val num = current.poll()
            if (num == B) {
                count++
                return
            }
            if (num * 2 <= B && !visited[(num * 2).toInt()]) {
                current.offer(num * 2)
                visited[(num * 2).toInt()] = true
            }
            if (num * 10 + 1 <= B && !visited[(num * 10 + 1).toInt()]) {
                current.offer(num * 10 + 1)
                visited[(num * 10 + 1).toInt()] = true
            }
        }
        count++
    }
    count = -1
}











