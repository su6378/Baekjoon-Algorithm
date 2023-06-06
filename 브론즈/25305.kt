package com.ssafy.algorithm

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var token = StringTokenizer(br.readLine())

    val N = token.nextToken().toInt()
    val k = token.nextToken().toInt()
    val scoreArr = IntArray(N)

    token = StringTokenizer(br.readLine())

    for (i in 0 until N){
        scoreArr[i] = token.nextToken().toInt()
    }

    scoreArr.sortDescending()

    bw.write(scoreArr[k-1].toString())

    bw.flush()
    bw.close()
}
