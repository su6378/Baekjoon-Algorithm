package com.example.algorithm

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val token = StringTokenizer(br.readLine())

    val E = token.nextToken()!!.toInt()
    val S = token.nextToken()!!.toInt()
    val M = token.nextToken()!!.toInt()

    var earth = 1
    var sun = 1
    var moon = 1
    var year = 1

    while(true){

        if (earth == E && sun == S && moon == M) break

        earth++
        sun++
        moon++
        year++

        if (earth > 15) earth = 1
        if (sun > 28) sun = 1
        if (moon > 19) moon = 1

    }

    bw.write(year.toString())

    bw.flush()
    bw.close()
}


