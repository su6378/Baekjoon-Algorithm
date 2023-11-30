import java.io.*

const val MOD = 1000000009

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val t = readLine().toInt()
    val dp = Array(1001) { LongArray(1001) }

    dp[1][1] = 1
    dp[2][1] = 1
    dp[2][2] = 1
    dp[3][1] = 1
    dp[3][2] = 2
    dp[3][3] = 1

    for (i in 4..1000) {
        for (j in 1..i) {
            dp[i][j] = (dp[i - 3][j - 1] + dp[i - 2][j - 1] + dp[i - 1][j - 1]) % MOD // 점화식
        }
    }

    repeat(t) {
        val (n, m) = readLine().split(" ").map { it.toInt() }

        bw.write("${dp[n][m]}\n")
    }

    bw.flush()
    bw.close()
}
