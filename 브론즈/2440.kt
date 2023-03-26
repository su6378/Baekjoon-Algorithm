import java.util.*
import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = readLine().toInt()

    for (i in n downTo 1) {
        for (j in 1..i) {
            bw.write("*")
        }
        if (i != 1) bw.write("\n")
    }

    bw.flush()
    bw.close()
}

