package com.example.test

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var token = StringTokenizer(br.readLine())

    val N = token.nextToken()!!.toInt()
    val M = token.nextToken()!!.toInt()

    val board = Array(N){CharArray(M)}
    var width = 'w'
    var height = 'h'

    var count = 0

    for (i in 0 until N){
        val input = br.readLine()
        for (j in 0 until M){
            board[i][j] = input[j]
        }
    }

    for (i in 0 until N){
        for (j in 0 until M){
            if (width != '-'){
                if (board[i][j] == '-'){
                    count++
                    width = '-'
                }else continue
            }else{
                if (board[i][j] == '-') continue
                else width = 'w'
            }
        }
        width = 'w'
    }

    for (i in 0 until M){
        for (j in 0 until N){
            if (height != '|'){
                if (board[j][i] == '|'){
                    count++
                    height = '|'
                }else continue
            }else{
                if(board[j][i] == '|') continue
                else height = 'h'
            }
        }
        height = 'h'
    }
    println(count)
}








