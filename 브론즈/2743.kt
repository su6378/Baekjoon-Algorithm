import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val word = readLine()

    bw.write("${word.length}")

    bw.flush()
    bw.close()
}