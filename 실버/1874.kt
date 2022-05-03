package com.example.test

import java.util.*
import java.io.*
import kotlin.system.exitProcess

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val stack = arrayListOf<Int>()
    val str = arrayListOf<String>()

    var max = 0

    repeat(n) {
        val num = br.readLine().toInt()

        if (max < num) {
            for (i in max + 1..num) {
                stack.add(i)
                str.add("+")
            }
            max = num
        }else if(stack[stack.size-1] != num){
            println("NO")
            exitProcess(0)
         }

        stack.removeAt(stack.lastIndex)
        str.add("-")
    }

    str.forEach { bw.write("$it\n") }

    bw.flush()
    bw.close()

}










