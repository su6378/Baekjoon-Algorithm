package com.example.test

import java.io.*
import java.util.*
import kotlin.collections.ArrayList

var N = 0
val visited = BooleanArray(100001)
val node = IntArray(100001)
val current_floor : Queue<Int> = LinkedList<Int>()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    N = br.readLine()!!.toInt()
    val pair = Array(N+1){ arrayListOf<Int>()}

    for (i in pair.indices){
        pair[i] = ArrayList()
    }

    visited[1] = true
    node[1] = 1

    for (i in 0 until N-1){
        val token = StringTokenizer(br.readLine())
        val pair1 = token.nextToken()!!.toInt()
        val pair2 = token.nextToken()!!.toInt()

        pair[pair1].add(pair2)
        pair[pair2].add(pair1)
    }

    current_floor.add(1)

    while (!current_floor.isEmpty()){
        val parent = current_floor.poll()

        for (i in pair[parent]){
            if (!visited[i]){
                visited[i] = true
                node[i] = parent
                current_floor.add(i)
            }
        }
    }

    for (i in 2 .. N){
        bw.write(node[i].toString()+"\n")
    }

    bw.flush()
    bw.close()
}









