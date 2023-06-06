package com.example.test

import java.io.*
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val T = br.readLine().toInt()

    for (i in 1..T){
        val queue : Queue<Pair<Int,Int>> = LinkedList()

        var token = StringTokenizer(br.readLine())

        val N = token.nextToken().toInt()
        val M = token.nextToken().toInt()

        val list = ArrayList<Int>()

        token = StringTokenizer(br.readLine())

        for (i in 0 until N){
            val importance = token.nextToken().toInt()

            queue.offer(Pair(i,importance))
            list.add(importance)
        }

        list.sortDescending()

        var count = 0

        while (true){

            val max = list[0]

            if (queue.peek().second == max){
                if (queue.peek().first == M){
                    count++
                    break
                }else{
                    count++
                    queue.poll()
                    list.removeFirstOrNull()
                }
            }else{
                queue.offer(queue.poll())
            }
        }
        bw.write("$count\n")
    }

    bw.flush()
    bw.close()
}













