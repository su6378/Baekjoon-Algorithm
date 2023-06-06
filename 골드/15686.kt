package com.example.test

import java.io.*
import java.util.*
import kotlin.collections.ArrayList

data class Point(val x : Int, val y: Int)

var N = 0
var M = 0
lateinit var city: Array<IntArray>
lateinit var copyArr: Array<IntArray>
lateinit var chicken: Array<IntArray>
lateinit var house: Array<IntArray>
var dx = intArrayOf(0, 0, -1, 1)
var dy = intArrayOf(-1, 1, 0, 0)
var min = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var token = StringTokenizer(br.readLine())
    N = token.nextToken().toInt()
    M = token.nextToken().toInt()

    min = Int.MAX_VALUE
    val chickenX: List<Int> = ArrayList()
    val chickenY: List<Int> = ArrayList()

    city = Array(N + 1) { IntArray(N + 1) }
    copyArr = Array(N + 1) { IntArray(N + 1) }
    var hCount = 0
    var cCount = 0

    for (i in 1..N) {
        token = StringTokenizer(br.readLine())
        for (j in 1..N) {
            city[i][j] = token.nextToken().toInt()
            copyArr[i][j] = city[i][j]
            if (city[i][j] === 1) {
                hCount++
            } else if (city[i][j] === 2) {
                cCount++
                copyArr[i][j] = 0
            }
        }
    }

    house = Array(hCount) { IntArray(2) }
    chicken = Array(cCount) { IntArray(2) }
    var hIndex = 0
    var cIndex = 0

    for (i in 1..N) {
        for (j in 1..N) {
            if (city[i][j] === 1) {
                house[hIndex][0] = i
                house[hIndex][1] = j
                hIndex++
            } else if (city[i][j] === 2) {
                chicken[cIndex][0] = i
                chicken[cIndex][1] = j
                cIndex++
            }
        }
    }
    val cArr = IntArray(M)

    permulation(0, 0, cArr)

    println(min)

}

fun copy(temp: Array<IntArray>) {
    for (i in 1..N) {
        for (j in 1..N) {
            temp[i][j] = copyArr[i][j]
        }
    }
}

fun permulation(start: Int, index: Int, cArr: IntArray) {
    if (index == M) {
        var distance = 0
        for (i in house.indices) {
            distance += bfs(house[i][0], house[i][1], cArr)
            if (distance > min) {
                break
            }
        }
        min = Math.min(min, distance)
        return
    }
    for (i in start until chicken.size) {
        cArr[index] = i
        permulation(i + 1, index + 1, cArr)
    }
}

fun bfs(row: Int, col: Int, cArr: IntArray): Int {
    val temp = Array(N + 1) {
        IntArray(
            N + 1
        )
    }
    var count = 0
    copy(temp)
    for (i in cArr.indices) {
        temp[chicken[cArr[i]][0]][chicken[cArr[i]][1]] = 2
    }
    val queue: Queue<Point> = LinkedList()
    val visited = Array(N + 1) {
        BooleanArray(
            N + 1
        )
    }
    queue.add(Point(col, row))
    visited[row][col] = true
    while (!queue.isEmpty()) {
        val qSize = queue.size
        for (i in 0 until qSize) {
            val point: Point = queue.poll()
            if (temp[point.y][point.x] == 2) {
                return count
            }
            for (j in dx.indices) {
                val x: Int = point.x + dx[j]
                val y: Int = point.y + dy[j]
                if (x in 1..N && y >= 1 && y <= N && !visited[y][x]) {
                    visited[y][x] = true
                    queue.add(Point(x, y))
                }
            }
        }
        count++
    }
    return count
}













