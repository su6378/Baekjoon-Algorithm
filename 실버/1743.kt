package com.example.test

import java.io.*
import java.util.*
import kotlin.math.max

data class Point(val x: Int, val y: Int)

var N = 0
var M = 0
var K = 0
val visited = Array(101) { BooleanArray(101) }
val passThrough = Array(101) { BooleanArray(101) }
val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)
var count = 0
var max = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var token = StringTokenizer(br.readLine())

    N = token.nextToken().toInt()
    M = token.nextToken().toInt()
    K = token.nextToken().toInt()

    for (i in 0 until K) {
        token = StringTokenizer(br.readLine())
        val x = token.nextToken().toInt()
        val y = token.nextToken().toInt()
        passThrough[x][y] = true
    }

    for (i in 1..N) {
        for (j in 1..M) {
            if (!visited[i][j] && passThrough[i][j]) {
                count = 0
                bfs(i, j)
                max = max(max, count)
            }
        }
    }
    println(max)
}

fun bfs(x : Int, y: Int){
    val trash: Queue<Point> = LinkedList()
    trash.add(Point(x,y))
    visited[x][y] = true
    count++

    while (!trash.isEmpty()){
        val point = trash.poll()
        for (i in 0..3) {
            val pointX = point.x + dx[i]
            val pointY = point.y + dy[i]
            if (pointX >= 1 && pointX <= N && pointY >= 1 && pointY <= M) {
                if (!visited[pointX][pointY] && passThrough[pointX][pointY]) {
                    visited[pointX][pointY] = true
                    trash.add(Point(pointX, pointY))
                    count++
                }
            }
        }
    }
}











