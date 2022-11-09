package com.ssafy.algorithm

import java.io.*
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine().toInt()
    val token = StringTokenizer(br.readLine())
    val array = IntArray(201)

    repeat(N){
        val num = token.nextToken().toInt()
        array[num+100]++
    }

    val target = br.readLine().toInt()
    println(array[target+100])
}