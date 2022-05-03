package com.example.test

import java.util.*
import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val stack = Stack<Char>()

    while (true) {
        val str = br.readLine().toString()

        if (str == ".") {
            break
        }

        for (i in str.indices) {
            if (str[i] == '(' || str[i] == '[') {
                stack.push(str[i])
            } else if (str[i] == ')') {
                if (stack.isEmpty()) stack.push(str[i])
                else {
                    if (stack.last() == '(') stack.pop()
                    else stack.push(str[i])
                }
            } else if (str[i] == ']') {
                if (stack.isEmpty()) stack.push(str[i])
                else {
                    if (stack.last() == '[') stack.pop()
                    else stack.push(str[i])
                }
            }
        }
        if(stack.isEmpty()) bw.write("yes\n")
        else bw.write("no\n")
        stack.clear()
    }
    bw.flush()
    bw.close()
}










