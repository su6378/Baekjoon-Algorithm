import java.util.*
import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    while (true){
        val word = readLine()

        if (word == "0") break

        val reverseWord = word.reversed()

        if (word == reverseWord) bw.write("yes\n")
        else bw.write("no\n")
    }
    bw.flush()
    bw.close()
}

