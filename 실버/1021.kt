package com.example.test

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var token = StringTokenizer(br.readLine())
    val N = token.nextToken().toInt()
    val M = token.nextToken().toInt()

    val deque : Deque<Int> = ArrayDeque()

    for (i in 1..N){
        deque.addLast(i)
    }

    var count = 0

    token = StringTokenizer(br.readLine())
    for (i in 1..M){
        val target = token.nextToken().toInt()
        val bLegnth = deque.indexOf(target)
        val fLegnth = deque.size - deque.indexOf(target)

        if (bLegnth <= fLegnth){
            while (true){
                if (deque.peekFirst() == target) {
                    deque.pollFirst()
                    break
                }
                deque.addLast(deque.pollFirst())
                count++

            }
        }else{
            while (true){
                if (deque.peekFirst() == target) {
                    deque.pollFirst()
                    break
                }
                deque.offerFirst(deque.pollLast())
                count++
            }
        }
    }

    bw.write("$count")

    bw.flush()
    bw.close()
}













