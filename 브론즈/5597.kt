package com.ssafy.algorithm

import java.io.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val students = IntArray(31)

    repeat(28){
        val student = br.readLine().toInt()
        students[student]++
    }

    for (i in 1..30){
        if (students[i] == 0) bw.write("$i\n")
    }

    bw.flush()
    bw.close()
}