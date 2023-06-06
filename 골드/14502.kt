package com.example.test

import java.io.*
import java.util.*

data class Node(val x: Int, val y: Int)

var N = 0
var M = 0
lateinit var laboratory: Array<IntArray>
lateinit var copy: Array<IntArray>
lateinit var virusList: ArrayList<Node>
var dx = intArrayOf(0, 0, -1, 1)
var dy = intArrayOf(-1, 1, 0, 0)
lateinit var visited: Array<BooleanArray>
var max = Int.MIN_VALUE


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var token = StringTokenizer(br.readLine())

    N = token.nextToken().toInt()
    M = token.nextToken().toInt()

    laboratory = Array(N) { IntArray(M) }
    copy = Array(N) { IntArray(M) }
    virusList = ArrayList()

    for (i in 0 until N) {
        token = StringTokenizer(br.readLine())
        for (j in 0 until M) {
            laboratory[i][j] = token.nextToken().toInt()
            copy[i][j] = laboratory[i][j]
            if (laboratory[i][j] === 2) {
                virusList.add(Node(j, i))
            }
        }
    }

    setting(0, 0)

    println(max)
}

fun copy(temp: Array<IntArray>) {
    for (i in 0 until N) {
        for (j in 0 until M) {
            temp[i][j] = laboratory[i][j]
        }
    }
}

fun setting(size: Int, start: Int) {
    if (size == 3) {
        max = Math.max(virus(), max)
        return
    }
    for (i in start until N * M) {
        val row = i / M
        val col = i % M
        if (laboratory[row][col] === 0) {
            laboratory[row][col] = 1
            setting(size + 1, i + 1)
            laboratory[row][col] = 0
        }
    }
}

fun virus(): Int {
    var count = 0
    val queue: Queue<Node> = LinkedList()
    visited = Array(N) { BooleanArray(M) }
    val temp = Array(N) {
        IntArray(
            M
        )
    }
    copy(temp)
    for (i in virusList.indices) {
        queue.add(Node(virusList[i].x, virusList[i].y))
        visited[virusList[i].y][virusList[i].x] = true
    }
    while (!queue.isEmpty()) {
        val point: Node = queue.poll()
        for (i in dx.indices) {
            val x: Int = point.x + dx[i]
            val y: Int = point.y + dy[i]
            if (x in 0 until M && y >= 0 && y < N && !visited[y][x] && temp[y][x] == 0) {
                visited[y][x] = true
                temp[y][x] = 2
                queue.add(Node(x, y))
            }
        }
    }
    for (i in 0 until N) {
        for (j in 0 until M) {
            if (temp[i][j] == 0) {
                count++
            }
        }
    }
    return count
}














