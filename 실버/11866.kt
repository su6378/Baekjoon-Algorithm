package com.example.test

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val token = StringTokenizer(br.readLine())

    val N = token.nextToken().toInt()
    val K = token.nextToken().toInt()

    val queue : Queue<Int> = LinkedList()

    for (i in 1..N){
        queue.offer(i)
    }

    bw.write("<")

    while (true){

        if (queue.size == 1){
            bw.write("${queue.poll()}>")
            break
        }

        repeat((K-1) % queue.size){
            queue.offer(queue.poll())
        }

        bw.write("${queue.poll()}, ")

    }

    bw.flush()
    bw.close()
}













