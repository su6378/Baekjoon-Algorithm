import java.io.*
import java.util.*
import kotlin.math.*

lateinit var st: StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = readLine().toInt()
    val house = Array(n) { IntArray(3) }
    val dp = Array(n) { IntArray(3) }

    repeat(n) {
        st = StringTokenizer(readLine())
        val red = st.nextToken().toInt()
        val green = st.nextToken().toInt()
        val blue = st.nextToken().toInt()

        house[it][0] = red
        house[it][1] = green
        house[it][2] = blue
    }

    dp[0][0] = house[0][0]
    dp[0][1] = house[0][1]
    dp[0][2] = house[0][2]

    // 다음 빨강, 초록, 파랑 집을 선택할 때는 이전의 같은 색깔이 아닌 집의 비용 중 최소의 비용을 선택해서 더한다.
    for (i in 1 until n){
        dp[i][0] = house[i][0] + min(dp[i-1][1], dp[i-1][2])
        dp[i][1] = house[i][1] + min(dp[i-1][0], dp[i-1][2])
        dp[i][2] = house[i][2] + min(dp[i-1][0], dp[i-1][1])
    }

    bw.write("${dp[n-1].min()}")

    bw.flush()
    bw.close()
}