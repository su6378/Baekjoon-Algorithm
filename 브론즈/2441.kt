import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = readLine().toInt()

    for (i in n downTo 1) {
        repeat(n - i) { bw.write(" ") }
        repeat(i) { bw.write("*") }
        bw.write("\n")
    }

    bw.flush()
    bw.close()
}