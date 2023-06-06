package com.example.test

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val T = br.readLine().toInt()
    val deque: Deque<Int> = ArrayDeque()
    for (i in 1..T) {

        deque.clear()

        val p = br.readLine()
        val n = br.readLine().toInt()
        val arrStr = br.readLine()
        val arrList = arrStr.substring(1, arrStr.length - 1).split(",")

        if (n > 0) {
            for (i in arrList) {
                val num = i.toInt()
                deque.addLast(num)
            }
        }

        var isError = false
        var isRight = true

        for (i in p.indices) {
            if (p[i] == 'R') {
                isRight = !isRight
            } else if (p[i] == 'D') {
                if (deque.isEmpty()) {
                    isError = true
                    break
                } else {
                    if (isRight) {
                        deque.pollFirst()
                    } else {
                        deque.pollLast()
                    }
                }
            }
        }

        if (!isError) {
            if (deque.isEmpty()) {
                bw.write("[]\n")
            } else {
                bw.write("[")
                if (isRight) {
                    while (true){
                        if (deque.size == 1){
                            bw.write("${deque.pollFirst()}]\n")
                            break
                        }
                        bw.write("${deque.pollFirst()},")
                    }
                } else {
                    while (true) {
                        if (deque.size == 1) {
                            bw.write("${deque.pollLast()}]\n")
                            break
                        }
                        bw.write("${deque.pollLast()},")
                    }
                }
            }
        } else {
            bw.write("error\n")
        }

    }
    bw.flush()
    bw.close()
}













