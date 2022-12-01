package com.ssafy.algorithm

import java.io.*
import java.util.LinkedList
import java.util.Queue

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val queue : Queue<Int> = LinkedList()

    while (true){
        val input = br.readLine().toInt()

        when(input){
            -1 -> break //입력 종료
            0 -> { // poll
                queue.poll()
            }
            else -> {
                if (queue.size < N){ //버퍼에 들어갈 수 있으면
                    queue.offer(input)
                }
            }
        }
    }

    if (queue.isEmpty()) println("empty")
    else println(queue.joinToString(" "))
}







