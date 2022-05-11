package com.example.test

import java.io.*
import java.util.*
import kotlin.collections.HashMap

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val token = StringTokenizer(br.readLine())
    val n = token.nextToken().toInt()
    val m = token.nextToken().toInt()

    val pokemon_book = HashMap<String, String>()
    for (i in 1..n) {
        val pokemon = br.readLine().toString()
        pokemon_book.put(pokemon, "$i")
        pokemon_book.put("$i", pokemon)
    }

    for (i in 0 until m) {
        val target = br.readLine().toString()
        bw.write("${pokemon_book.get(target)}\n")
    }

    bw.flush()
    bw.close()
}

