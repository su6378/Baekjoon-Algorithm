import java.io.*
import java.util.StringTokenizer
import kotlin.math.*

lateinit var st: StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val t = readLine().toInt()
    var dp: Array<IntArray>

    repeat(t) {
        val n = readLine().toInt()
        dp = Array(2) { IntArray(n + 1) }

        repeat(2) { i ->
            st = StringTokenizer(readLine())

            repeat(n) { j ->
                dp[i][j + 1] = st.nextToken().toInt()
            }
        }

        for (i in 2..n) {
            dp[0][i] = dp[0][i] + max(dp[1][i - 1], max(dp[0][i - 2], dp[1][i - 2]))
            dp[1][i] = dp[1][i] + max(dp[0][i - 1], max(dp[0][i - 2], dp[1][i - 2]))
        }

        bw.write("${max(dp[0][n], dp[1][n])}\n")
    }

    bw.flush()
    bw.close()
}