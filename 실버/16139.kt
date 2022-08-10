package com.ssafy.algorithm

import java.io.*
import java.util.*


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val S = br.readLine()
    val sum = Array(S.length) {
        IntArray(26)
    }

    sum[0][S[0] - 'a']++

    for (i in 1 until S.length) {
        val tmp = S[i] - 'a'
        for (j in 0..25) {
            sum[i][j] = sum[i - 1][j]
        }
        sum[i][tmp]++
    }

    val q = br.readLine().toInt()
    val sb = StringBuilder()
    for (i in 0 until q) {
        val st = StringTokenizer(br.readLine())
        val find = st.nextToken()[0]
        val s = st.nextToken().toInt()
        val e = st.nextToken().toInt()
        if (s == 0) {
            sb.append(sum[e][find - 'a']).append('\n')
        } else {
            sb.append(sum[e][find - 'a'] - sum[s - 1][find - 'a']).append('\n')
        }
    }

    println(sb)
}

