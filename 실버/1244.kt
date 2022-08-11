package com.example.test

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine().toInt()
    val sw = IntArray(N + 1)

    var token = StringTokenizer(br.readLine())
    for (i in 1 until sw.size) {
        sw[i] = token.nextToken().toInt()
    }

    val student = br.readLine().toInt()
    for (i in 0 until student) {
        token = StringTokenizer(br.readLine())
        val gender = token.nextToken().toInt()
        val num = token.nextToken().toInt()
        if (gender == 1) {
            for (j in 1 until sw.size) {
                if (j % num == 0) {
                    sw[j] = change(sw[j])
                }
            }
        } else if (gender == 2) {
            var move = 1
            sw[num] = change(sw[num])
            while (true) {
                if (num - move >= 1 && num + move <= N) {
                    if (sw[num - move] == sw[num + move]) {
                        sw[num - move] = change(sw[num - move])
                        sw[num + move] = change(sw[num + move])
                        move++
                    } else {
                        break
                    }
                } else break
            }
        }
    }

    for (i in 1 until sw.size) {
        if (i != 1 && i % 20 == 1) {
            println()
            print(sw[i].toString() + " ")
        } else print(sw[i].toString() + " ")
    }

}

fun change(num: Int): Int {
    var num = num
    if (num == 0) num = 1 else if (num == 1) num = 0
    return num
}












