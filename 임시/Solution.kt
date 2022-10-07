package com.ssafy.algorithm

import java.io.*

var N = 0
lateinit var board : Array<CharArray>
var max = 0

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))

    N = br.readLine().toInt()

    max = 0
    board = Array(N){CharArray(N)}

    for (i in 0 until N){
        val candy = br.readLine()
        for (j in 0 until N){
            board[i][j] = candy[j]
        }
    }

    for (i in 0 until N){
        for (j in 0 until N-1){
            if (board[i][j] != board[i][j+1]){ //서로 같지 않을 때
                board[i][j] = board[i][j+1].also { board[i][j+1] = board[i][j]} //열 바꾸기
                rowCheck()
                colCheck()
                board[i][j] = board[i][j+1].also { board[i][j+1] = board[i][j]} //다시 원래대로 돌려주기
            }

            if (board[j][i] != board[j+1][i]){
                board[j][i] = board[j+1][i].also { board[j+1][i] = board[j][i] } //행 바꾸기기
                rowCheck()
                colCheck()
                board[j][i] = board[j+1][i].also { board[j+1][i] = board[j][i] } //행 바꾸기기
            }

        }
   }
    print(max)
}

fun rowCheck(){
    for (row in board.indices){
        var count = 1
        for (col in 1 until board.size){
            if (board[row][col] == board[row][col-1]) count++
            else{ //도중에 끊기면 최대값 갱신
                max = Math.max(max,count)
                count = 0
            }
        }
        max = Math.max(max,count) //한줄이 끝나고 max값 갱신
    }
}

fun colCheck(){
    for (col in board.indices){
        var count = 1
        for (row in 1 until board.size){
            if (board[row][col] == board[row-1][col]) count++
            else{ //도중에 끊기면 최대값 갱신
                max = Math.max(max,count)
                count = 0
            }
        }
        max = Math.max(max,count) //한줄이 끝나고 max값 갱신
    }
}





