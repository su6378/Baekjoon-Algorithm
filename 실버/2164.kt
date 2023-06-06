package com.ssafy.algorithm

import java.io.*
import java.util.*


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val N = br.readLine().toInt()
    val queue : Queue<Int> = LinkedList()
    var num = 0

    for (i in 1..N){
        queue.offer(i)
    }

    while (true){
        if (queue.size == 1){
            num = queue.poll()
            break
        }

        queue.poll()
        queue.offer(queue.poll())

    }

    println(num)
}

