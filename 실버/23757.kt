package com.ssafy.algorithm

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var gift = PriorityQueue<Int>(reverseOrder())
    var children = PriorityQueue<Int>(reverseOrder())

    var token = StringTokenizer(br.readLine())

    val N = token.nextToken().toInt()
    val M = token.nextToken().toInt()
    var isHappy = 1

    token = StringTokenizer(br.readLine())
    repeat(N){
        gift.offer(token.nextToken().toInt())
    }

    token = StringTokenizer(br.readLine())
    for(i in 0 until M){
        val child = token.nextToken().toInt()
        val max = gift.poll()
        if (child > max) {
            isHappy = 0
            break
        }
        gift.offer(max-child)
    }

    println(isHappy)
}







