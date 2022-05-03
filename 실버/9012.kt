package com.example.test

import java.util.*
import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val t = br.readLine().toInt()
    val stack = Stack<Char>()

    repeat(t) {
        val vps = br.readLine().toString()
        if (vps[0] == ')') bw.write("NO\n")
        else {
            stack.push(vps[0])
            for (i in 1 until vps.length) {
                if (vps[i] == '(') {
                    stack.push(vps[i])
                } else {
                    if (stack.isEmpty()) stack.push(vps[i])
                    else {
                        if (stack.last() == '(') stack.pop()
                        else stack.push(vps[i])
                    }
                }

            }

            if (stack.isEmpty()) bw.write("YES\n")
            else bw.write("NO\n")
            stack.clear()
        }

    }

    bw.flush()
    bw.close()

}










