import java.io.*
import java.util.StringTokenizer

lateinit var st: StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = readLine().split(" ").map { it.toInt() }
    val numArr = Array(n + 1) { IntArray(n + 1) }
    val sumArr = Array(n + 1) { IntArray(n + 1) }

    for (i in 1..n) {
        st = StringTokenizer(readLine())
        for (j in 1..n) {
            numArr[i][j] = st.nextToken().toInt()
            sumArr[i][j] = sumArr[i - 1][j] + sumArr[i][j - 1] - sumArr[i - 1][j - 1] + numArr[i][j]
        }
    }

    repeat(m) {
        st = StringTokenizer(readLine())
        val x1 = st.nextToken().toInt()
        val y1 = st.nextToken().toInt()
        val x2 = st.nextToken().toInt()
        val y2 = st.nextToken().toInt()
        bw.write("${sumArr[x2][y2] - sumArr[x2][y1-1] - sumArr[x1-1][y2] + sumArr[x1 - 1][y1 - 1]}\n")
    }

    bw.flush()
    bw.close()
}