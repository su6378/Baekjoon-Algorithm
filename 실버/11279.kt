package com.ssafy.algorithm

fun main() {
    val flowers = arrayOf(intArrayOf(3,4), intArrayOf(4,5), intArrayOf(6,7), intArrayOf(8,10))//arrayOf(intArrayOf(2,5), intArrayOf(3,7), intArrayOf(10,11))
    println(Solution().solution(flowers))
}

class Solution {
    fun solution(flowers: Array<IntArray>): Int {
        var answer: Int = 0
        val blossom = IntArray(366) //꽃이 피는 날짜 배열

        for (flower in flowers){
            val bDay = flower[0] //꽃이 피기 시작하는 날짜
            val fDay = flower[1] //꽃이 지기 시작하는 날짜

            for (i in bDay until fDay){
                blossom[i]++
            }
        }

        for (day in blossom){
            if (day >= 1) answer++ //꽃이 피어있다면 answer++
        }

        return answer
    }
}