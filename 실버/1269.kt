package com.example.test

import java.io.*
import java.util.*
import kotlin.collections.HashMap


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var token = StringTokenizer(br.readLine())

    val A = token.nextToken()!!.toInt()
    val B = token.nextToken()!!.toInt()

    val map = HashMap<Int,Int>()

    token = StringTokenizer(br.readLine())

    for (i in 0 until A){
        map.put(token.nextToken()!!.toInt(),1)
    }

    token = StringTokenizer(br.readLine())

    for (i in 0 until B){
        val key = token.nextToken()!!.toInt()
        if (map.containsKey(key)){
            map.remove(key)
        }else{
            map.put(key,1)
        }
    }

    println(map.size)

}












