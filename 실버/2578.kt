package com.example.test

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

lateinit var chulsu: Array<IntArray>
var bingo = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    chulsu = Array(5) { IntArray(5) }
    val host = Array(5) { IntArray(5) }

    var count = 0

    for (i in chulsu.indices) {
        val token = StringTokenizer(br.readLine())
        for (j in chulsu.indices) {
            chulsu[i][j] = token.nextToken().toInt()
        }
    }

    for (i in host.indices) {
        val token = StringTokenizer(br.readLine())
        for (j in host.indices) {
            host[i][j] = token.nextToken().toInt()
        }
    }

    var isFinish = false

    for (i in host.indices) {
        for (j in host.indices) {
            count++
            sign(host[i][j])
            if (count >= 10) {
                val check: Boolean = check()
                if (check) {
                    isFinish = true
                    break
                }
            }
        }
        if (isFinish) {
            break
        }
    }

    println(count)

}

fun sign(num: Int) {
    for (i in chulsu.indices) {
        for (j in chulsu.indices) {
            if (chulsu[i][j] === num) {
                chulsu[i][j] = 0
            }
        }
    }
}

fun check(): Boolean {
    bingo = 0
    rowCheck()
    if (bingo >= 3) return true
    colCheck()
    if (bingo >= 3) return true
    crossCheck()
    return if (bingo >= 3) true else false
}

fun rowCheck() {
    for (i in chulsu.indices) {
        var rowBingo = true
        for (j in chulsu.indices) {
            if (chulsu[i][j] !== 0) {
                rowBingo = false
                break
            }
        }
        if (rowBingo) {
            bingo++
        }
    }
}

fun colCheck() {
    for (i in chulsu.indices) {
        var colBingo = true
        for (j in chulsu.indices) {
            if (chulsu[j][i] !== 0) {
                colBingo = false
                break
            }
        }
        if (colBingo) {
            bingo++
        }
    }
}

fun crossCheck() {
    var crossBingo = true
    for (i in chulsu.indices) {
        if (chulsu[i][i] !== 0) {
            crossBingo = false
            break
        }
    }
    if (crossBingo) {
        bingo++
    }
    var rvCrossBingo = true
    for (i in chulsu.indices) {
        if (chulsu[i][chulsu.size - 1 - i] !== 0) {
            rvCrossBingo = false
            break
        }
    }
    if (rvCrossBingo) {
        bingo++
    }
}











