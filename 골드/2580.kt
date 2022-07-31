package com.example.test

import java.io.*
import java.util.*

data class Point(var x : Int, var y :Int)

val sudoku = Array(9){IntArray(9)}
var zero_point : LinkedList<Point> = LinkedList()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    for (i in 0 until 9){
        val token = StringTokenizer(br.readLine())
        for (j in 0 until 9){
            sudoku[i][j] = token.nextToken()!!.toInt()
            if (sudoku[i][j] == 0) zero_point.add(Point(i,j))
        }
    }
    DFS(0)
}

fun DFS(depth : Int){
    if(depth == zero_point.size){
        for(i in 0 until 9){
            for(j in 0 until 9){
                print(sudoku[i][j].toString()+" ")
            }
            println()
        }
        System.exit(0)
    }
    val point = zero_point[depth]
    val x = point.x
    val y = point.y

    for(i in 1..9){
        if(check(x,y,i)){
            sudoku[x][y] = i
            DFS(depth+1)
            sudoku[x][y] = 0
        }
    }
}

fun check(x : Int, y : Int, num : Int) : Boolean{
    if(sudoku[x][y] != 0) return false

    for(i in 0 until 9){
        if(sudoku[i][y] == num || sudoku[x][i] == num)  return false
    }

    val x2 = x / 3 * 3
    val y2 = y / 3 * 3
    for(i in x2 until x2 + 3){
        for(j in y2 until y2 + 3){
            if(sudoku[i][j] == num) return false
        }
    }
    return true
}




