package com.ssafy.algorithm

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


var house = Array(17) { IntArray(17) }
var N = 0
var count = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    N = br.readLine().toInt()

    for (i in 1..N) {
        val token = StringTokenizer(br.readLine())
        for (j in 1..N) {
            house[i][j] = token.nextToken().toInt()
        }
    }


    dfs(2, 1, 1)

    println(count)
}
fun dfs(col: Int, row: Int, direction: Int) {
    if (col == N && row == N) {
        count++
        return
    }
    when (direction) {
        1 -> if (col + 1 <= N && house[row][col + 1] === 0) { // 가로
            dfs(col + 1, row, 1)
        }
        2 -> if (row + 1 <= N && house[row + 1][col] === 0) { // 세로
            dfs(col, row + 1, 2)
        }
        3 -> {
            if (row + 1 <= N && house[row + 1][col] === 0) { // 세로
                dfs(col, row + 1, 2)
            }
            if (col + 1 <= N && house[row][col + 1] === 0) { // 가로
                dfs(col + 1, row, 1)
            }
        }
    }

    // 대각선
    if (row + 1 <= N && col + 1 <= N && house[row][col + 1] === 0 && house[row + 1][col] === 0 && house[row + 1][col + 1] === 0) {
        dfs(col + 1, row + 1, 3)
    }
}
