import java.io.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.*

lateinit var st: StringTokenizer
var graph = ArrayList<ArrayList<Pair<Int, Int>>>()
var rGraph = ArrayList<ArrayList<Pair<Int, Int>>>()
lateinit var dist: IntArray
lateinit var rDist: IntArray
var n = 0
var m = 0
var x = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    st = StringTokenizer(readLine())
    n = st.nextToken().toInt()
    m = st.nextToken().toInt()
    x = st.nextToken().toInt()

    repeat(n + 1) {
        graph.add(ArrayList())
        rGraph.add(ArrayList())
    }

    repeat(m) {
        st = StringTokenizer(readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val t = st.nextToken().toInt()

        graph[a].add(Pair(b, t))
        rGraph[b].add(Pair(a, t))
    }

    dijkstra()
    rDijkstra()

    var answer = 0

    for (i in 1..n) {
        answer = max(answer, dist[i] + rDist[i])
    }

    bw.write("$answer")

    bw.flush()
    bw.close()
}

fun dijkstra() {
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    val visited = BooleanArray(n + 1)

    dist = IntArray(n + 1) { Integer.MAX_VALUE }
    dist[x] = 0

    pq.add(Pair(x, 0))

    while (pq.isNotEmpty()) {
        val cur = pq.poll()

        if (visited[cur.first]) continue
        visited[cur.first] = true

        for (next in graph[cur.first]) {
            if (dist[next.first] > cur.second + next.second) {
                dist[next.first] = cur.second + next.second
                pq.add(Pair(next.first, dist[next.first]))
            }
        }
    }
}

fun rDijkstra() {
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    val visited = BooleanArray(n + 1)

    rDist = IntArray(n + 1) { Integer.MAX_VALUE }
    rDist[x] = 0

    pq.add(Pair(x, 0))

    while (pq.isNotEmpty()) {
        val cur = pq.poll()

        if (visited[cur.first]) continue
        visited[cur.first] = true

        for (next in rGraph[cur.first]) {
            if (rDist[next.first] > cur.second + next.second) {
                rDist[next.first] = cur.second + next.second
                pq.add(Pair(next.first, rDist[next.first]))
            }
        }
    }
}