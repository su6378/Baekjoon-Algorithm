package com.ssafy.algorithm

import java.io.*
import java.util.*
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val N = br.readLine().toInt()

    var pq = PriorityQueue<Int> { o1, o2 ->
        var abs1 = abs(o1)
        var abs2 = abs(o2)
        // 두 값의 값이 같을 경우, 부호를 비교해서 오름차순으로 정렬.
        // 두 값이 다를 경우, 그냥 절댓값에서 숫자의 크기로 비교해서 오름차순으로 정렬
        when (abs1) {
            abs2 -> o1 - o2
            else -> abs1 - abs2
        }
    } //poll하면 절대값이 작은 수 부터 나온다.

    repeat(N) {
        val info = br.readLine().toInt()
        when (info) {
            0 -> {
                if (pq.isEmpty()) { //비어있으면 0 출력
                    bw.write("0\n")
                } else {
                    bw.write("${pq.poll()}\n")
                }
            }
            else -> {
                pq.offer(info)
            }
        }
    }

    bw.flush()
    bw.close()
}







