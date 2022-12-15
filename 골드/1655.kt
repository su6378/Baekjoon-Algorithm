package com.ssafy.algorithm

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val minPq = PriorityQueue<Int>(reverseOrder()) //작은 수의 우선순위 큐
    val maxPq = PriorityQueue<Int>() // 큰 수로 이루어진 우선순위 큐

    val N = br.readLine().toInt()

    repeat(N){
        val num = br.readLine().toInt()

        if (minPq.size == maxPq.size) minPq.offer(num) //서로 크기가 같으면 min부터 채워 넣기
        else maxPq.offer(num)

        if (minPq.isNotEmpty() && maxPq.isNotEmpty()){ //작은 수의 가장 큰 값과 큰 수의 집합에서 가장 작은 값을 비교하여 서로 갱신하기
            if (minPq.peek()!! > maxPq.peek()!!){
                val temp = minPq.poll()
                minPq.offer(maxPq.poll())
                maxPq.offer(temp)
            }
        }
        //중간값 출력
        bw.write("${minPq.peek()}\n")
    }

    bw.flush()
    bw.close()
}







