package com.example.test

import java.io.*
import kotlin.collections.ArrayList

lateinit var num: ArrayList<Int>
lateinit var op: ArrayList<Char>
var max = Int.MIN_VALUE


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine().toInt()
    val sik = br.readLine()

    num = ArrayList()
    op = ArrayList()

    for (i in 0 until N) {
        if ((i + 1) % 2 == 1) { // 숫자 리스트에 삽입
            num.add(Character.getNumericValue(sik[i]))
        } else { // 연산 리스트에 삽입
            op.add(sik[i])
        }
    }

    dfs(0, num[0])

    println(max)
}

fun dfs(size: Int, sum: Int) {
    if (size == op.size) { // 최댓값 찾기
        max = Math.max(max, sum)
        return
    }
    dfs(size + 1, calculate(sum, num[size + 1], op[size])) // 시작부터 괄호치기
    if (size + 2 <= op.size) {
        dfs(
            size + 2, calculate(
                sum, calculate(num[size + 1], num[size + 2], op[size + 1]),
                op[size]
            )
        )
    }
}

fun calculate(left: Int, right: Int, op: Char): Int {
    return if (op == '+') {
        left + right
    } else if (op == '-') {
        left - right
    } else {
        left * right
    }
}












