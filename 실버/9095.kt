import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val dp = IntArray(11)

    dp[1] = 1
    dp[2] = 2
    dp[3] = 4

    for (i in 4..10) dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1]

    val n = readLine().toInt()

    repeat(n) { bw.write("${dp[readLine().toInt()]}\n") }

    bw.flush()
    bw.close()
}