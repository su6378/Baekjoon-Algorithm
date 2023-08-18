import java.io.*
import java.util.*
import kotlin.math.min

lateinit var st: StringTokenizer
lateinit var dist: Array<IntArray>

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = readLine().toInt()
    val m = readLine().toInt()

    dist = Array(n + 1) { IntArray(n + 1) { Integer.MAX_VALUE / 2 } }

    repeat(n) { dist[it + 1][it + 1] = 0 }

    repeat(m) {
        st = StringTokenizer(readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val c = st.nextToken().toInt()

        dist[a][b] = min(dist[a][b], c)
    }

    for (k in 1..n) {
        for (i in 1..n) {
            for (j in 1..n) {
                dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]);
            }
        }
    }

    for (i in 1..n) {
        for (j in 1..n) {
            if (dist[i][j] == Integer.MAX_VALUE / 2) bw.write("0 ")
            else bw.write("${dist[i][j]} ")
        }
        bw.write("\n")
    }

    bw.flush()
    bw.close()
}