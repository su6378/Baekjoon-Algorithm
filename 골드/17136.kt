package com.ssafy.algorithm

import java.io.*
import java.util.*


lateinit var paper: Array<IntArray> //종이
lateinit var papers: IntArray //색종이 카운트
var result = 0 //최소값

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    paper = Array(10) { IntArray(10) }

    for (i in 0 until paper.size) {
        val token = StringTokenizer(br.readLine())
        for (j in 0 until paper.size) {
            paper[i][j] = token.nextToken().toInt()
        }
    }

    papers = IntArray(6)
    for (i in 1 until papers.size) {
        papers[i] = 5
    }

    result = Int.MAX_VALUE

    search(0, 0, 0)

    if (result == Int.MAX_VALUE) { //제한된 갯수보다 많이 붙인경우
        result = -1
    }

    println(result)
}

fun search(row: Int, col: Int, count: Int) {
    if (row >= 9 && col > 9) { //마지막점에 도달했을 때 result값 갱신
        result = Math.min(result, count)
        return
    }
    if (result <= count) { //result값이 count값보다 작거나 같으면 탐색할 필요없으므로 다음 탐색
        return
    }
    if (col > 9) { //다음 행 검색
        search(row + 1, 0, count)
        return
    }
    if (paper[row][col] === 1) {
        for (i in 5 downTo 1) { //5크기 종이부터 탐색
            if (papers[i] > 0 && attach(
                    row,
                    col,
                    i
                )
            ) { //남아있는 종이 수 && 배열의 범위 벗어나지 않는지 체크 + 다음 인덱스 값이 0인지 체크
                init(row, col, i, 0)
                papers[i]-- //i 크기의 종이 수 감소
                search(row, col + 1, count + 1)
                init(row, col, i, 1)
                papers[i]++
            }
        }
    } else {
        search(row, col + 1, count) //0이므로 다음 검색
    }
}

fun init(row: Int, col: Int, size: Int, state: Int) { //value 값 0으로 갱신 후 재귀함수 종료후에 1로 채우기
    for (i in row until row + size) {
        for (j in col until col + size) {
            paper[i][j] = state
        }
    }
}

fun attach(row: Int, col: Int, size: Int): Boolean {
    for (i in row until row + size) {
        for (j in col until col + size) {
            if (i < 0 || i >= 10 || j < 0 || j >= 10) {
                return false
            }
            if (paper[i][j] !== 1) {
                return false
            }
        }
    }
    return true
}
