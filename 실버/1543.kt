package com.example.test

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val document = br.readLine()
    val word = br.readLine()

    var doc_idx = 0
    var word_idx = 0
    var last_idx = 0;

    var count = 0

    while (true) {
        if (doc_idx == document.length) break
        if (document.elementAt(doc_idx) == word.elementAt(word_idx)) {

            if (word_idx == word.length - 1) {
                word_idx = 0
                doc_idx++
                last_idx = doc_idx
                count++
            } else {
                doc_idx++
                word_idx++
            }
        } else {
            last_idx++
            doc_idx = last_idx
            word_idx = 0
        }
    }
    println(count)
}