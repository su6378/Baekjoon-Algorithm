package com.example.test

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val N = br.readLine().toInt()

    val deque : Deque<Int> = ArrayDeque()

    for (i in 1..N){
        val token = StringTokenizer(br.readLine())

        val command = token.nextToken()

        if (command == "push_back"){
            val num = token.nextToken().toInt()
            deque.addLast(num)
        }else if(command == "push_front"){
            val num = token.nextToken().toInt()
            deque.offerFirst(num)
        }else if(command == "front"){
            if (deque.isEmpty()) bw.write("-1\n")
            else bw.write("${deque.peekFirst()}\n")
        }else if(command == "back"){
            if (deque.isEmpty()) bw.write("-1\n")
            else bw.write("${deque.peekLast()}\n")
        }else if(command == "size"){
            bw.write("${deque.size}\n")
        }else if(command == "empty"){
            if (deque.isEmpty()) bw.write("1\n")
            else bw.write("0\n")
        }else if(command == "pop_front"){
            if (deque.isEmpty()) bw.write("-1\n")
            else bw.write("${deque.pollFirst()}\n")
        }else if(command == "pop_back"){
            if (deque.isEmpty()) bw.write("-1\n")
            else bw.write("${deque.pollLast()}\n")
        }
    }

    bw.flush()
    bw.close()
}













