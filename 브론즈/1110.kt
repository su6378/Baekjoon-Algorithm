package com.example.test

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val N = br.readLine()!!.toInt()
    var count = 0
    var number = N

    while (true) {

        val left = number / 10
        val right = number % 10

        if (number < 10) {
            number *= 11
            count++
        } else {
            number = (10 * right) + (left + right) % 10
            count++
        }
        if (number == N) break
    }

    bw.write(count.toString())

    bw.flush()
    bw.close()
}