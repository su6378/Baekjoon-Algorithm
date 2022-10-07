package com.ssafy.component_2

import java.io.*
import java.util.*
import kotlin.collections.ArrayList

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))

    var token = StringTokenizer(br.readLine())
    var N = token.nextToken().toInt()
    val M = token.nextToken().toInt()

    val plusPoint = ArrayList<Int>()// 양수 좌표 배열
    val minusPoint =  ArrayList<Int>() // 음수 좌표 배열
    val result = ArrayList<Int>() //방문한 가장 최장 거리 책 리스트
    token = StringTokenizer(br.readLine())


    for (i in 0 until N){ //각 영역에 좌표 채우기
        val point = token.nextToken().toInt()
        if (point < 0) minusPoint.add(point)
        else plusPoint.add(point)
    }

    //내림차순 정렬
    minusPoint.sort()
    plusPoint.sortDescending()

    while (N > 0){
        if (minusPoint.isEmpty() && plusPoint.isNotEmpty()){ // 음수로 이루어진 좌표
            val plusMax = plusPoint.maxOrNull()!!
            result.add(Math.abs(plusMax))
            for (i in 1..M){
                plusPoint.removeAt(0)
                N--
                if (N == 0) break
            }
        }else if(minusPoint.isNotEmpty() && plusPoint.isEmpty()){ //양수로 이루어진 좌표
            val minusMax = Math.abs(minusPoint.minOrNull()!!)
            result.add(Math.abs(minusMax))
            for (i in 1..M){
                minusPoint.removeAt(0)
                N--
                if (N == 0) break
            }
        }else if(minusPoint.isNotEmpty() && plusPoint.isNotEmpty()){ //둘다 있을 경우
            val minusMax = Math.abs(minusPoint.minOrNull()!!)
            val plusMax = plusPoint.maxOrNull()!!

            if (minusMax >= plusMax) { //절대값이 음수 좌표가 가장 크거나 같은 경우
                result.add(Math.abs(minusMax))
                for (i in 1..M){ //음수 좌표 쪽에 책을 꽂다가 다 꽂거나 음수 좌표 영역이 비어있다면 break
                    minusPoint.removeAt(0)
                    N--
                    if (N == 0 || minusPoint.isEmpty()) break
                }
            }else{
                result.add(plusMax)
                for (i in 1..M){
                    plusPoint.removeAt(0)
                    N--
                    if (N == 0 || plusPoint.isEmpty()) break
                }
            }
        }
    }

    var sum = 0
    result.forEachIndexed { index, value ->
        if (index == 0) sum += value
        else sum += value * 2
    }

    println("$sum")
}