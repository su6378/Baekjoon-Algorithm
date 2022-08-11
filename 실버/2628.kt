package com.example.test

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var token = StringTokenizer(br.readLine())

    val wList: MutableList<Int> = ArrayList()
    val hList: MutableList<Int> = ArrayList()

    val width = token.nextToken().toInt()
    val height = token.nextToken().toInt()

    wList.add(width)
    hList.add(height)

    val points = br.readLine().toInt()

    for (i in 0 until points) {
        token = StringTokenizer(br.readLine())
        val direction = token.nextToken().toInt()
        var slice = token.nextToken().toInt()
        if (direction == 0) {
            var index = 0
            index = 0
            while (slice - hList[index] > 0) {
                slice -= hList[index]
                index++
            }
            val temp = hList.removeAt(index)
            hList.add(index, temp - slice)
            hList.add(index, slice)
        } else {
            var index = 0
            index = 0
            while (slice - wList[index] > 0) {
                slice -= wList[index]
                index++
            }
            val temp = wList.removeAt(index)
            wList.add(index, temp - slice)
            wList.add(index, slice)
        }
    }

    var wMax = Int.MIN_VALUE
    var hMax = Int.MIN_VALUE

    for (i in wList) {
        wMax = Math.max(wMax, i!!)
    }

    for (i in hList) {
        hMax = Math.max(hMax, i!!)
    }

    println(wMax * hMax)
}













