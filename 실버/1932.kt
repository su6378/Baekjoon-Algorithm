import java.io.*
import java.util.*
import kotlin.math.max

lateinit var st: StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = readLine().toInt()
    val triangle = Array(n + 1) { IntArray(n + 1) }

    for (i in 1..n) {
        st = StringTokenizer(readLine())
        for (j in 1..i) {
            triangle[i][j] = st.nextToken().toInt()
        }
    }

    for (i in 1..n) {
        for (j in 1..i) {
            triangle[i][j] = triangle[i][j] + max(triangle[i-1][j], triangle[i-1][j-1])
        }
    }

    bw.write("${triangle[n].max()}")

    bw.flush()
    bw.close()
}