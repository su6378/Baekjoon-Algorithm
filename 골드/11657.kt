import java.io.*
import java.util.*
import kotlin.collections.ArrayList

lateinit var st: StringTokenizer
val graph = ArrayList<Triple<Int, Int, Int>>()
lateinit var dist: LongArray
const val INF = 987654321L

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = readLine().split(" ").map { it.toInt() }

    repeat(m) {
        st = StringTokenizer(readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val c = st.nextToken().toInt()

        graph.add(Triple(a, b, c))
    }

    if (bellmanFord(n, m)) {
        for (i in 2..n) {
            if (dist[i] == INF) bw.write("-1\n")
            else bw.write("${dist[i]}\n")
        }
    } else bw.write("-1")

    bw.flush()
    bw.close()
}

fun bellmanFord(n: Int, m: Int): Boolean {
    dist = LongArray(n + 1) { INF.toLong() }

    dist[1] = 0

    for (i in 0 until n) {
        for (j in 0 until m) {
            val e = graph[j]

            if (dist[e.first] != INF && dist[e.second] > dist[e.first] + e.third) {
                dist[e.second] = dist[e.first] + e.third
            }
        }
    }

    for (i in 0 until m) {
        val e = graph[i]

        if (dist[e.first] != INF && dist[e.second] > dist[e.first] + e.third) return false
    }
    return true
}