package com.example.test

import java.io.*
import java.util.*

private lateinit var bad: Array<BooleanArray>
private lateinit var combination: IntArray

private lateinit var visited: BooleanArray
private lateinit var ic_arr: IntArray

private var count = 0;


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var token = StringTokenizer(br.readLine())
    val N = token.nextToken()!!.toInt()
    val M = token.nextToken()!!.toInt()

    bad = Array<BooleanArray>(N + 1) { BooleanArray(N + 1) }
    combination = IntArray(3)

    visited = BooleanArray(N + 1)
    ic_arr = IntArray(N + 1)

    for (i in 1..N) {
        ic_arr[i - 1] = i
    }

    for (i in 0 until M) {
        token = StringTokenizer(br.readLine())
        val ic = token.nextToken()!!.toInt()
        val ic2 = token.nextToken()!!.toInt()

        bad[ic][ic2] = true
        bad[ic2][ic] = true

    }

    comb(0,0,N)
    println(count)
}

private fun comb(index : Int, size : Int, length : Int){
    if (size == 3){
        for (i in 0 until 3){
            for (j in 0 until 3){
                if (bad[combination[i]][combination[j]]) return
            }
        }
        count++
        return
    }

    for (i in index until length){
        if (!visited[i]){
            visited[i] = true
            combination[size] = ic_arr[i]
            comb(i,size+1,length)
            visited[i] = false
        }
    }
}


