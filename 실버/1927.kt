package com.ssafy.algorithm

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val N = br.readLine().toInt()
    val pq = PriorityQueue<Int>() //poll하면 작은 수 부터 나온다.

    repeat(N){
        val info = br.readLine().toInt()

        when(info){
            0 -> {
                if (pq.isEmpty()){ //비어있으면 0 출력
                    bw.write("0\n")
                }else{
                    bw.write("${pq.poll()}\n")
                }
            }
            else ->{
                pq.add(info)
            }
        }
    }

    bw.flush()
    bw.close()
}







