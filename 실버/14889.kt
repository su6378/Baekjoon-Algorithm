package com.example.test

import java.io.*
import java.util.*

var N = 0
lateinit var team: Array<IntArray>
lateinit var visited: BooleanArray
lateinit var start: IntArray
lateinit var link: IntArray
var min = Int.MAX_VALUE


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    N = br.readLine().toInt()
    team = Array(N + 1) { IntArray(N + 1) } //1부터 시작인덱스


    for (i in 1..N) {
        val token = StringTokenizer(br.readLine())
        for (j in 1..N) {
            team[i][j] = token.nextToken().toInt()
        }
    }

    visited = BooleanArray(N + 1)

    combination(1, 0)

    println(min)
}

fun combination(index: Int, size: Int) {
    if (min == 0) { //최솟값이 0이면 탐색종료
        return
    }
    if (size == N / 2) { //N/2일 때 팀 인원 배치한것을 기준으로 계산 시작
        min = Math.min(min, getMinValue())
        return
    }
    for (i in index..N) {
        if (!visited[i]) {
            visited[i] = true
            combination(i + 1, size + 1)
            visited[i] = false
        }
    }
}

fun getMinValue(): Int {
    var diff = Int.MAX_VALUE
    start = IntArray(N / 2)
    link = IntArray(N / 2)
    var sIndex = 0
    var lIndex = 0
    for (i in 1 until visited.size) { //true인 곳은 start false인 곳은 link
        if (visited[i]) {
            start[sIndex] = i
            sIndex++
        } else {
            link[lIndex] = i
            lIndex++
        }
    }
    var sSum = 0
    var lSum = 0
    for (i in 0 until start.size) { //team[i][i]는 0이므로 이중포문으로 팀 능력치 계산
        for (j in 0 until start.size) {
            sSum += team[start[i]][start[j]]
            lSum += team[link[i]][link[j]]
        }
    }
    diff = Math.abs(sSum - lSum)
    return diff
}













