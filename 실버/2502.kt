package com.example.test

import java.io.*
import java.util.*


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val token = StringTokenizer(br.readLine())
    val D = token.nextToken()!!.toInt()
    val K = token.nextToken()!!.toInt()

    val k_arr = IntArray(D) { 0 }

    for (i in 1..K / 2) {
        for (j in i + 1 until K) {
            k_arr[0] = i
            k_arr[1] = j

            for (k in 2 until D) {
                k_arr[k] = k_arr[k - 2] + k_arr[k - 1]
            }
            if (k_arr[D - 1] == K) {
                println(k_arr[0])
                println(k_arr[1])
                System.exit(0)
            }
        }
    }
}






