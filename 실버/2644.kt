package com.example.test

import java.io.*
import java.util.*
import kotlin.collections.ArrayList

var n = 0
var p1 = 0
var p2 = 0
var m = 0
var visited = BooleanArray(101)
lateinit var relation: Array<ArrayList<Int>>
var distance = -1

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    n = br.readLine().toInt()

    relation = Array(n+1){ ArrayList<Int>() }

    for (i in 1..n) {
        relation[i] = ArrayList()
    }

    var token = StringTokenizer(br.readLine())

    p1 = token.nextToken().toInt()
    p2 = token.nextToken().toInt()

    m = br.readLine().toInt()


    for (i in 0 until m) {
        token = StringTokenizer(br.readLine())
        val x = token.nextToken().toInt()
        val y = token.nextToken().toInt()
        relation[x].add(y)
        relation[y].add(x)
    }

    dfs(p1, p2, 0)

    println(distance)
}

fun dfs(start: Int, target: Int, count: Int) {
    if (start == target) {
        distance = count
        return
    }
    visited[start] = true
    for (i in 0 until relation[start].size) {
        val next = relation[start][i]
        if (!visited[next]) {
            dfs(next, target, count + 1)
        }
    }
}











