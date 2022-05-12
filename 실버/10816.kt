package com.example.test

import java.io.*
import java.util.*
import kotlin.collections.HashMap

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val cards = HashMap<Int, Int>()
    val n = br.readLine().toInt()
    val token = StringTokenizer(br.readLine())

    for (i in 1..n) {
        val card_num = token.nextToken().toInt()
        if (cards.containsKey(card_num)) {
            cards[card_num] = cards.getValue(card_num) + 1
        } else cards.put(card_num, 1)
    }

    val m = br.readLine().toInt()
    val token2 = StringTokenizer(br.readLine())

    for (i in 1..m) {
        val num = token2.nextToken().toInt()
        bw.write("${cards.getOrDefault(num, 0)} ")
    }

    bw.flush()
    bw.close()
}

