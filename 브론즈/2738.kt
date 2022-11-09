package com.ssafy.algorithm

import java.io.*
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))

    var token = StringTokenizer(br.readLine())

    val N = token.nextToken().toInt()
    val M = token.nextToken().toInt()

    val A = Array(N){IntArray(M)}

    repeat(N*2){ row ->
        token = StringTokenizer(br.readLine())
        repeat(M){ col ->
            if(row < N) A[row][col] = token.nextToken().toInt()
            else A[row - N][col] += token.nextToken().toInt()
        }
    }

    for (arr in A){
        println(arr.joinToString(" "))
    }
}