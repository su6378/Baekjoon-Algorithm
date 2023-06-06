package com.ssafy.algorithm

import java.io.*
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))

    var square = Array(100){IntArray(100)}

    val N = br.readLine().toInt()
    var count = 0

    repeat(N){
        val token = StringTokenizer(br.readLine())
        val C = token.nextToken().toInt()
        val R = token.nextToken().toInt()

        for (i in 90-R ..99-R){
            for (j in C-1 until C+9){
                square[i][j] = 1
            }
        }
    }

    for (i in square.indices){
        for (j in square[i].indices){
            if (square[i][j] == 1) count++
        }
    }
    println(count)
}