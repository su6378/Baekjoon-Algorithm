import java.io.*
import java.util.*

lateinit var st: StringTokenizer
lateinit var dp: Array<IntArray>
lateinit var map: Array<IntArray>
var n = 0
var m = 0
var dir = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    st = StringTokenizer(readLine())
    n = st.nextToken().toInt()
    m = st.nextToken().toInt()

    dp = Array(n + 1) { IntArray(m + 1) { -1 } }
    map = Array(n + 1) { IntArray(m + 1) }

    repeat(n) { i ->
        st = StringTokenizer(readLine())
        repeat(m) { j ->
            map[i + 1][j + 1] = st.nextToken().toInt()
        }
    }

    bw.write("${dfs(1, 1)}")

    bw.flush()
    bw.close()
}

fun dfs(x: Int, y: Int): Int {
    if (x == m && y == n) return 1

    if (dp[y][x] != -1) return dp[y][x]

    dp[y][x] = 0

    for (i in 0 until 4) {
        val nx = dir[i][1] + x
        val ny = dir[i][0] + y

        if (nx !in 1..m || ny !in 1..n) continue

        if (map[ny][nx] < map[y][x]) dp[y][x] += dfs(nx, ny)
    }
    return dp[y][x]
}