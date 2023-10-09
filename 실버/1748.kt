import java.io.*
import kotlin.math.pow
import kotlin.text.StringBuilder

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = readLine().toInt()
    var x = 1
    var count = 0L

    if (n < 10) bw.write("$n")
    else {
        while (true) {
            if (10.0.pow(x) > n) {
                val sb = StringBuilder()
                repeat(x - 1) { sb.append(9) }

                count += (n - sb.toString().toInt()) * x.toLong()
                break
            }

            count += 9 * 10.0.pow(x - 1).toLong() * x
            x++
        }

        bw.write("$count")
    }

    bw.flush()
    bw.close()
}