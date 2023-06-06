package com.example.test

import java.io.*
import java.util.*

var N = 0
var M = 0
var D = 0
var archers = IntArray(3)
lateinit var visited: Array<BooleanArray>
var max = Int.MIN_VALUE
lateinit var castle: Array<IntArray>
lateinit var temp: Array<IntArray>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var token = StringTokenizer(br.readLine())
    N = token.nextToken().toInt()
    M = token.nextToken().toInt()
    D = token.nextToken().toInt()

    castle = Array(N + 1) { IntArray(M + 1) }
    temp = Array(N + 1) { IntArray(M + 1) } // 복사 배열


    for (i in 1..N) {
        token = StringTokenizer(br.readLine())
        for (j in 1..M) {
            castle[i][j] = token.nextToken().toInt()
            temp[i][j] = castle[i][j]
        }
    }

    archers = IntArray(3)

    combination(0, 1, archers, castle)

    println(max)
}


fun combination(size: Int, start: Int, archers: IntArray, castle: Array<IntArray>) { // 궁수 자리 배치
    if (size == 3) {
        copy() // 배열 초기화
        max = Math.max(max, defense(archers))
        return
    }
    for (i in start..M) {
        archers[size] = i
        combination(size + 1, i + 1, archers, castle)
    }
}


fun copy() {
    for (i in 1..N) {
        for (j in 1..M) {
            castle[i][j] = temp[i][j]
        }
    }
}

fun defense(archers: IntArray): Int {
    var count = 0
    for (n in 1..N) { // 총 N번 이동
        visited = Array(N + 1) { BooleanArray(M + 1) }
        for (k in archers.indices) {
            val archerX = archers[k] // 궁수의 x좌표
            var minD = Int.MAX_VALUE
            var minR = Int.MAX_VALUE
            var minC = Int.MAX_VALUE
            for (i in 1..N) { // 시작점부터 1인곳을 탐색
                for (j in 1..M) {
                    if (castle[i][j] === 1) {
                        val distance = Math.abs(i - (N + 1)) + Math.abs(j - archerX) // 거리계산
                        if (minD >= distance) {
                            if (minD > distance) { // 최소거리보다 작으면 거리,x,y갱신
                                minD = distance
                                minR = i
                                minC = j
                            } else {
                                if (minC > j) { // 거리같으면 왼쪽부터 쏜다고했으니 왼쪽 좌표 갱신
                                    minR = i
                                    minC = j
                                }
                            }
                        }
                    }
                }
            }
            if (minD <= D) { // 거리가 가장 최소이고 같으면 왼쪽인 좌표를 방문
                visited[minR][minC] = true
            }
        }
        for (i in 1..N) { // 궁수가 같은 적을 쏠수도 있기때문에 체크배열을 통해 count갱신
            for (j in 1..M) {
                if (visited[i][j]) {
                    castle[i][j] = 0
                    count++
                }
            }
        }
        for (i in 1..M) { // 적이 성에 도착
            castle[N][i] = 0
        }
        for (i in N downTo 1) { // 윗줄 적을 아래로 1칸씩
            for (j in 1..M) {
                castle[i][j] = castle[i - 1][j]
            }
        }
    }
    return count
}











