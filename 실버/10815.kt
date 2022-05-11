package com.example.test

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    var cards = IntArray(n)
    val token = StringTokenizer(br.readLine())

    for (i in 0 until n) {
        val num1 = token.nextToken().toInt()
        cards[i] = num1
    }

    cards = cards.sortedArray()

    val m = br.readLine().toInt()
    val checks = IntArray(m)
    val token2 = StringTokenizer(br.readLine())

    for (i in 0 until m) {
        val num2 = token2.nextToken().toInt()
        checks[i] = num2
    }

    for (i in checks.indices) {
        bw.write("${binary(cards, checks[i])} ")
    }

    bw.flush()
    bw.close()

}

fun binary(arr: IntArray, target: Int) : Int {
    var low = 0
    var high = arr.size - 1
    var mid: Int

    while (low <= high) {
        mid = (low + high) / 2

        if (target == arr[mid]) return 1
        else if(target < arr[mid]) high = mid - 1
        else low = mid + 1

    }
    return 0
}