package com.ssafy.algorithm

import java.io.*
import java.util.*


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val N = br.readLine().toInt()
    val queue : Queue<Int> = LinkedList()

    for (i in 1..N){
        val token = StringTokenizer(br.readLine())
        val command = token.nextToken()

        if (command == "push"){
            val num = token.nextToken().toInt()
            queue.offer(num)
        }else if(command == "front"){
            if (queue.isEmpty()){
                bw.write("-1\n")
            }else{
                bw.write("${queue.peek()}\n")
            }
        }else if(command == "back"){
            if (queue.isEmpty()){
                bw.write("-1\n")
            }else{
                bw.write("${queue.last()}\n")
            }
        }else if(command == "size"){
            bw.write("${queue.size}\n")
        }else if (command == "empty"){
            if (queue.isEmpty()){
                bw.write("1\n")
            }else{
                bw.write("0\n")
            }
        }else if(command == "pop"){
            if (queue.isEmpty()){
                bw.write("-1\n")
            }else{
                bw.write("${queue.poll()}\n")
            }
        }
    }
    bw.flush()
    bw.close()
}

