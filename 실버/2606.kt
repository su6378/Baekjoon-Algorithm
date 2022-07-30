package com.example.test

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val computer = br.readLine()!!.toInt()
    val pair = br.readLine()!!.toInt()
    val pairs = Array(pair){IntArray(2)}

    val infected = BooleanArray(101)
    val last : Queue<Int> = LinkedList<Int>()

    infected[0] = true
    infected[1] = true

    last.add(1)

    for (i in 0 until pair){
        val token = StringTokenizer(br.readLine())
        pairs[i][0] = token.nextToken()!!.toInt()
        pairs[i][1] = token.nextToken()!!.toInt()
    }

    while (true){
        if (last.isEmpty()) break

        val last_index = last.poll()

        for (i in pairs.indices){
            if (pairs[i][0] == last_index) {
                if (!infected[pairs[i][1]]) {
                    infected[pairs[i][1]] = true
                    last.add(pairs[i][1])
                }
            }else if(pairs[i][1] == last_index) {
                if (!infected[pairs[i][0]]) {
                    infected[pairs[i][0]] = true
                    last.add(pairs[i][0])
                }
            }
        }
    }

    var count = 0

    for (i in 2 until infected.size){
        if (infected[i]) count++
    }

    println(count)
}








