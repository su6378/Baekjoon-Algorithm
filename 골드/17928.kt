package com.example.test

import java.util.*
import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val stack = Stack<Int>()

    val n = br.readLine().toInt()
    val arr = IntArray(n)

    val token = StringTokenizer(br.readLine())
    for (i in 0 until n) {
        val num = token.nextToken().toInt()
        arr[i] = num
    }

    for(i in arr.indices){
          while(stack.isNotEmpty() && arr[stack.peek()] < arr[i]){
            arr[stack.pop()] = arr[i]
          }
        stack.push(i)
    }

    while(stack.isNotEmpty()){
        arr[stack.pop()] = -1
    }

    arr.forEach { bw.write("$it ") }


    bw.flush()
    bw.close()
}










