package com.example.test

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var time = 0
var distance: Queue<Int> = LinkedList()
var visited = BooleanArray(100001)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val token = StringTokenizer(br.readLine())

    val N = token.nextToken().toInt()
    val K = token.nextToken().toInt()

    bfs(N, K)
}

fun bfs(N: Int, K: Int) {
    distance.offer(N)
    visited[N] = true
    while (!distance.isEmpty()) {
        val size = distance.size
        for (i in 0 until size) {
            val currentN = distance.poll()
            if (currentN == K) {
                println(time)
                return
            }
            if (currentN - 1 >= 0 && !visited[currentN - 1]) { // N위치가 K위치보다 클 때
                visited[currentN - 1] = true
                distance.offer(currentN - 1)
            }
            if (currentN + 1 <= 100000 && !visited[currentN + 1]) { // 걷기
                visited[currentN + 1] = true
                distance.offer(currentN + 1)
            }
            if (currentN * 2 <= 100000 && !visited[currentN * 2]) { // 순간이동
                visited[currentN * 2] = true
                distance.offer(currentN * 2)
            }
        }
        time++
    }
}











