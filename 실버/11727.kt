import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = readLine().toInt()

    val dp = IntArray(1001)

    dp[1] = 1
    dp[2] = 3

    // 점화식 f(n) = f(n-1) + 2 * f(n-2)
    if (n > 2) {
        for (i in 3..n) {
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007
        }
    }

    bw.write("${dp[n]}")

    bw.flush()
    bw.close()
}