import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val word = readLine()
    val reverse = StringBuilder(word).reverse()

    if (word == reverse.toString()) bw.write("1")
    else bw.write("0")

    bw.flush()
    bw.close()
}