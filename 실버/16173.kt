package com.example.test

import java.io.*
import java.util.*

var N = 0
lateinit var area : Array<IntArray>
lateinit var visited : Array<BooleanArray>
val dx = intArrayOf(1,0)
val dy = intArrayOf(0,1)
val jelly : Queue<IntArray> = LinkedList<IntArray>()
var result = "Hing"

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    N = br.readLine()!!.toInt()

    area = Array(N) { IntArray(N) }
    jelly.add(intArrayOf(0,0))
    visited = Array(N) {BooleanArray(N)}

    for (i in area.indices) {
        val token = StringTokenizer(br.readLine())
        for (j in area.indices) {
            area[i][j] = token.nextToken()!!.toInt()
        }
    }

    move()
    println(result)
}

fun move(){
    while (!jelly.isEmpty()){
        val point = jelly.poll()

        for (i in 0 until 2){
            val x = point[0] + (dx[i] * area[point[0]][point[1]])
            val y = point[1] + (dy[i] * area[point[0]][point[1]])

            if (x in 0 until N && y in 0 until N) {
                if (area[x][y] == -1) {
                    result = "HaruHaru"
                    jelly.clear()
                    break
                } else {
                    if (!visited[x][y]) {
                        jelly.add(intArrayOf(x, y))
                        visited[x][y] = true
                    }
                }
            }
        }
    }
}








