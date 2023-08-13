import java.io.*
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val str1 = readLine()
    val str2 = readLine()
    val dp = Array(str1.length + 1) { IntArray(str2.length + 1) }

    for (i in 1..str1.length) {
        for (j in 1..str2.length) {
            if (str1[i - 1] == str2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1
            else dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
        }
    }

    bw.write("${dp[str1.length][str2.length]}")

    bw.flush()
    bw.close()
}