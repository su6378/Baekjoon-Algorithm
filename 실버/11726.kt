import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val dp = IntArray(1001)

    dp[1] = 1
    dp[2] = 2

    for (i in 3..1000) dp[i] = (dp[i - 2] + dp[i - 1]) % 10007

    bw.write("${dp[readLine().toInt()]}")

    bw.flush()
    bw.close()
}