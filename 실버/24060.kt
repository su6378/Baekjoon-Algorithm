package com.ssafy.algorithm

import java.io.*
import java.util.*

lateinit var temp : IntArray
lateinit var A : IntArray 
var count = 0
var K = 0
var answer = -1

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))

    var token = StringTokenizer(br.readLine())
    val N = token.nextToken().toInt()
    K = token.nextToken().toInt()
    A = IntArray(N)
    temp = IntArray(N)

    token = StringTokenizer(br.readLine())
    repeat(N){
        A[it] = token.nextToken().toInt()
    }

    merge_sort(0, N - 1)  //배열은 0부터 n-1까지이기 때문에
    println(answer)
}

fun merge_sort(p : Int, r : Int) { //# A[p..r]을 오름차순 정렬한다.
    var q = 0
    if (p < r) {
        q = (p + r) / 2 //# q는 p, r의 중간 지점
        merge_sort(p, q) //# 전반부 정렬
            merge_sort(q + 1, r)  ///# 후반부 정렬
            merge(p, q, r);       // # 병합
    }
}

//# A[p..q]와 A[q+1..r]을 병합하여 A[p..r]을 오름차순 정렬된 상태로 만든다.
//# A[p..q]와 A[q+1..r]은 이미 오름차순으로 정렬되어 있다.
fun merge(p : Int, q : Int, r : Int){
    var i = p
    var j = q + 1
    var t = 0

    while (i <= q && j <= r) {
        if (A[i] <= A[j])
            temp[t++] = A[i++]
        else
            temp[t++] = A[j++]
    }

    while (i <= q)
        temp[t++] = A[i++]
    while (j <= r)
        temp[t++] = A[j++]
    i = p; t = 0;			
    while (i <= r) {
        A[i++] = temp[t++]
        count++
        if(count == K) {
            answer = A[i-1]
            return
        }
    }
}