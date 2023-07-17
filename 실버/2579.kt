import java.io.*
import kotlin.math.max

lateinit var scores: IntArray
lateinit var dp: IntArray

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = readLine().toInt()

    scores = IntArray(n + 1)
    dp = IntArray(n + 1) { -1 }

    for (i in 1..n) {
        scores[i] = readLine().toInt()
    }

    dp[0] = scores[0]
    dp[1] = scores[1]

    if (n >= 2) dp[2] = dp[1] + scores[2]

    for (i in 3..n) { // Bottom Up 방식
        dp[i] = max(dp[i - 2], dp[i - 3] + scores[i - 1]) + scores[i]
    }

    bw.write("${dp[n]}")

    bw.flush()
    bw.close()
}