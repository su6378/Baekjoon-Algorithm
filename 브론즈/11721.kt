import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var word = readLine()
    val sb = StringBuilder()

    for (i in word.indices) {
        sb.append(word[i])

        if (sb.length == 10) {
            bw.write("$sb\n")
            sb.setLength(0)
        }
    }

    if (sb.isNotEmpty()) bw.write("$sb")

    bw.flush()
    bw.close()
}