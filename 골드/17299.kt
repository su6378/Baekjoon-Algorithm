package com.ssafy.algorithm

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val N = br.readLine().toInt()
    val token = StringTokenizer(br.readLine())

    val stack = Stack<Int>()
    val array = IntArray(N)
    val count = IntArray(1000001) //해당 숫자의 나타난 횟수를 담아낸 배열
    val result = IntArray(N)

    repeat(N){
        array[it] = token.nextToken().toInt()
    }

    array.forEachIndexed { index, i ->
        count[array[index]]++
    }

    stack.push(0) //시작 인덱스

    for (i in 1 until array.size){
        while (stack.isNotEmpty() && count[array[stack.peek()]] < count[array[i]]) { //오큰수를 찾으면
            result[stack.peek()] = array[i]
            stack.pop() //해당 인덱스에서 오큰수를 찾았으므로 pop
        }
        stack.push(i) //다음 비교할 인덱스 삽입
    }

    while (stack.isNotEmpty()){
        result[stack.pop()] = -1 //오큰수를 찾지못한 인덱스에 -1 갱신
    }

    for (num in result){
        bw.write("$num ")
    }

    bw.flush()
    bw.close()
}







