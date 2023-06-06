package com.ssafy.algorithm

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val total = br.readLine().toInt()
    val count = br.readLine().toInt()
    var sum = 0

    for (i in 1..count){
        val token = StringTokenizer(br.readLine())

        val price = token.nextToken().toInt()
        val pCount = token.nextToken().toInt()

        sum += price * pCount

    }

    if (total == sum){
        bw.write("Yes")
    }else{
        bw.write("No")
    }

    bw.flush()
    bw.close()
}
