import java.io.*
import kotlin.math.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = readLine().toInt()

    val dp = IntArray(n+1)

    dp[1] = 1

    for (i in 2..n) {
        var minValue = Integer.MAX_VALUE
        var j = 1
        while (j * j <= i) {
            val tmp = i - j * j
            minValue = min(minValue, dp[tmp]) // dp[제곱수]중에서 가장 작은 값 찾기
            j++
        }
        dp[i] = minValue+1
    }

    bw.write("${dp[n]}")

    bw.flush()
    bw.close()
}