package com.ssafy.algorithm

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val N = br.readLine().toInt()

    val colorPaper = Array(1001) { IntArray(1001) }

    for (i in 1..N) {
        val token = StringTokenizer(br.readLine())
        val x1 = token.nextToken().toInt()
        val y1 = token.nextToken().toInt()
        val width = token.nextToken().toInt()
        val height = token.nextToken().toInt()
        for (j in 1000 - y1 - height + 1..1000 - y1) {
            for (k in x1 until x1 + width) {
                colorPaper[j][k] = i
            }
        }
    }

    for (i in 1..N) {
        var count = 0
        for (j in colorPaper.indices) {
            for (k in colorPaper.indices) {
                if (colorPaper[j][k] == i) {
                    count++
                }
            }
        }
        bw.write("$count\n")
    }

    bw.flush()
    bw.close()
}

