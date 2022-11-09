package com.ssafy.algorithm

import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))

    val scores = IntArray(5)

    repeat(5){
        val score = br.readLine().toInt()
        scores[it] = score
    }

    scores.sort()
    println("${scores.average().toInt()}\n${scores[2]}")

}