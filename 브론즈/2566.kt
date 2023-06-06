package com.ssafy.algorithm

import java.io.*
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))

    var max = Integer.MIN_VALUE
    var R = 0
    var C = 0

    repeat(9){ row ->
        var token = StringTokenizer(br.readLine())
        repeat(9){ col ->
         val num = token.nextToken().toInt()
            if (max < num) {
                max = num
                R = row+1
                C = col+1
            }
        }
    }
    println(max)
    println("$R $C")
}