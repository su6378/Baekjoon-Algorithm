import java.io.*
import java.util.StringTokenizer
import kotlin.math.max

lateinit var st: StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, k) = readLine().split(" ").map { it.toInt() }
    val items = Array(n + 1) { IntArray(2) }

    repeat(n) {
        st = StringTokenizer(readLine())
        items[it + 1][0] = st.nextToken().toInt() // v
        items[it + 1][1] = st.nextToken().toInt() // w
    }

    val dp = Array(n + 1) { IntArray(k + 1) }

    // knapsack
    for (i in 1..n) {
        for (j in 1..k) {
            if (items[i][0] > j) { // 해당 위치에 물건을 넣을 수 없는 경우
                dp[i][j] = dp[i - 1][j]
            } else {
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - items[i][0]] + items[i][1])
            }
        }
    }

    bw.write("${dp[n][k]}")

    bw.flush()
    bw.close()
}