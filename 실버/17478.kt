package com.example.test

import java.io.*

val br = BufferedReader(InputStreamReader(System.`in`))
val bw = BufferedWriter(OutputStreamWriter(System.out))

fun main() {

    val N = br.readLine()!!.toInt()

    bw.write("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n")
    bw.write("\"재귀함수가 뭔가요?\"\n")
    bw.write("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n")
    bw.write("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n")
    bw.write("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n")
    recursive(N, 1)
    bw.write("라고 답변하였지.")
    bw.flush()
    bw.close()
}

fun recursive(repeat: Int, count: Int) {

    if (count == repeat) {
        repeat(count*4) { bw.write("_") }
        bw.write("\"재귀함수가 뭔가요?\"\n")
        repeat(count*4) { bw.write("_") }
        bw.write("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n")
        for (i in repeat downTo 1){
            repeat(i*4) { bw.write("_") }
            bw.write("라고 답변하였지.\n")
        }
        return
    }
    repeat(count*4) { bw.write("_") }
    bw.write("\"재귀함수가 뭔가요?\"\n")
    repeat(count*4) { bw.write("_") }
    bw.write("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n")
    repeat(count*4){bw.write("_")}
    bw.write("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n")
    repeat(count*4){bw.write("_")}
    bw.write("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n")
    recursive(repeat, count + 1)
}




