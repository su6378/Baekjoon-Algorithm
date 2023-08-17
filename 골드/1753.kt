import java.io.*
import java.util.*
import kotlin.collections.ArrayList

lateinit var st: StringTokenizer
lateinit var graph: ArrayList<ArrayList<Pair<Int, Int>>>
lateinit var dist: IntArray

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (v, e) = readLine().split(" ").map { it.toInt() }
    val k = readLine().toInt()

    graph = ArrayList()
    dist = IntArray(v + 1){Integer.MAX_VALUE}

    repeat(v + 1) { graph.add(ArrayList()) }

    repeat(e) {
        st = StringTokenizer(readLine())
        val start = st.nextToken().toInt()
        val end = st.nextToken().toInt()
        val weight = st.nextToken().toInt()

        graph[start].add(Pair(end, weight))
    }

    dijkstra(k)

    for (i in 1..v){
        if (dist[i] == Integer.MAX_VALUE) bw.write("INF\n")
        else bw.write("${dist[i]}\n")
    }

    bw.flush()
    bw.close()
}

fun dijkstra(s: Int) {
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })

    pq.add(Pair(s, 0))
    dist[s] = 0

    while (pq.isNotEmpty()){
        val cur = pq.poll()

        for (next in graph[cur.first]){
            if (cur.second + next.second < dist[next.first]){
                dist[next.first] = cur.second + next.second
                pq.add(Pair(next.first, dist[next.first]))
            }
        }
    }
}