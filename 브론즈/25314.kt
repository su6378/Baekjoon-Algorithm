import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = readLine().toInt()

    repeat(n / 4) { bw.write("long ") }

    bw.write("int")

    bw.flush()
    bw.close()
}