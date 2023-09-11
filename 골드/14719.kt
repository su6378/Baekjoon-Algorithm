import java.io.*
import java.util.StringTokenizer
import kotlin.math.*

lateinit var st: StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var answer = 0

    val (h, w) = readLine().split(" ").map { it.toInt() }

    val block = IntArray(w)
    st = StringTokenizer(readLine())

    repeat(w) { block[it] = st.nextToken().toInt() }

    for (i in 1 until w - 1) {
        var left = 0
        var right = 0

        for (j in 0 until i) {
            left = max(left, block[j])
        }

        for (j in i + 1 until w) {
            right = max(right, block[j])
        }

        if (block[i] < left && block[i] < right) answer += min(left, right) - block[i]
    }

    bw.write("$answer")

    bw.flush()
    bw.close()
}