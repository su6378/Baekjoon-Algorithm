package com.example.test

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()

    val arr = IntArray(n)

    for(i in 0 until n){
        val num = br.readLine().toInt()
        arr[i] = num
    }

    arr.sort()


    var gcdNum = arr[1] - arr[0]

    for(i in 2 until n){
        gcdNum = gcd(gcdNum,arr[i]-arr[i-1])
    }


    for(i in 2 .. gcdNum){
        if(gcdNum % i == 0){
            bw.write("$i ")
        }
    }

    bw.flush()
    bw.close()

}

fun gcd(a : Int , b: Int) :Int = if (b!= 0) gcd(b,a%b) else a













