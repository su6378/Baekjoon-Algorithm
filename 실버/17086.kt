package com.example.test

import java.io.*
import java.util.*
import kotlin.math.max

data class Point(var x : Int, var y : Int)
var N = 0;
var M = 0;
var distance = 0
lateinit var space: Array<IntArray>
lateinit var visited: Array<IntArray>
val dx = intArrayOf(-1, -1, -1, 1, 1, 1, 0, 0)
val dy = intArrayOf(-1, 0, 1, -1, 0, 1, -1, 1)
val shark : Queue<Point> = LinkedList()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var token = StringTokenizer(br.readLine())

    N = token.nextToken()!!.toInt()
    M = token.nextToken()!!.toInt()

    space = Array(N) { IntArray(M) }
    visited = Array(N) { IntArray(M) { Int.MAX_VALUE } }

    for (i in 0 until N) {
        token = StringTokenizer(br.readLine())
        for (j in 0 until M) {
            space[i][j] = token.nextToken()!!.toInt()

            if (space[i][j] == 1) {
                shark.add(Point(i,j))
                visited[i][j] = 0
            }
        }
    }
    bfs()
    println(distance)
}

fun bfs() {
    while (!shark.isEmpty()) {
        val point = shark.poll()
        for (i in dx.indices) {
            val x = point.x + dx[i]
            val y = point.y + dy[i]
            if (x in 0 until N && y >= 0 && y < M) {
                if (visited[x][y] > visited[point.x][point.y] + 1) {
                    visited[x][y] = visited[point.x][point.y] + 1
                    distance = max(distance, visited[x][y])
                    shark.add(Point(x,y))
                }
            }
        }
    }
}









