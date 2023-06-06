package com.example.test

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

data class Point(val x : Int, val y: Int)

var N = 0
var L = 0
var r = 0
lateinit var land: Array<IntArray>
var dx = intArrayOf(0, 0, -1, 1) // 거리벡터 상하좌우
var dy = intArrayOf(-1, 1, 0, 0)
lateinit var visited: Array<BooleanArray>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var token = StringTokenizer(br.readLine())

    N = token.nextToken().toInt()
    L = token.nextToken().toInt()
    r = token.nextToken().toInt()

    land = Array(N) { IntArray(N) }
    visited = Array(N) { BooleanArray(N) }

    for (element in land) {
        token = StringTokenizer(br.readLine())
        for (j in land.indices) {
            element[j] = token.nextToken().toInt()
        }
    }

    var day = 0
    var flag = true
    while (flag) {
        if (movePeople() === 0) {
            flag = false
        } else {
            day++
        }
    }

    println(day)

}

fun movePeople(): Int {
    var unionCount = 0
    for (a in 0 until N) {
        for (b in 0 until N) {
            if (!visited[a][b]) {
                val queue: Queue<Point> = LinkedList()
                queue.add(Point(b, a))
                visited[a][b] = true
                val list: MutableList<Point> = ArrayList()
                list.add(Point(b, a))
                var sum = land[a][b]
                while (!queue.isEmpty()) {
                    val (x1, y1) = queue.poll()
                    for (i in dx.indices) {
                        val x = x1 + dx[i]
                        val y = y1 + dy[i]
                        if (x in 0 until N && y >= 0 && y < N && !visited[y][x] && checkArea(
                                x, y,
                                x1, y1
                            )
                        ) {
                            queue.add(Point(x, y))
                            list.add(Point(x, y))
                            visited[y][x] = true
                            unionCount++
                            sum += land[y][x]
                        }
                    }
                }
                if (unionCount > 0) {
                    val average = sum / list.size
                    for (i in list.indices) {
                        val (x, y) = list[i]
                        land[y][x] = average
                    }
                }
            }
        }
    }
    for (i in 0 until N) {
        Arrays.fill(visited[i], false)
    }
    return unionCount
}

fun checkArea(x: Int, y: Int, pointX: Int, pointY: Int): Boolean {
    val diff = Math.abs(land[y][x] - land[pointY][pointX])
    return diff in L..r
}














