package com.ssafy.algorithm

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val token = StringTokenizer(br.readLine())

    val dKing = token.nextToken().toInt()
    val dQueen = token.nextToken().toInt()
    val dLook = token.nextToken().toInt()
    val dBishop = token.nextToken().toInt()
    val dKnight = token.nextToken().toInt()
    val dPawn = token.nextToken().toInt()

    val king = 1 - dKing
    val queue = 1 - dQueen
    val look = 2 - dLook
    val bishop = 2 - dBishop
    val knight = 2 - dKnight
    val pawn = 8 - dPawn

    bw.write("$king $queue $look $bishop $knight $pawn")

    bw.flush()
    bw.close()
}
