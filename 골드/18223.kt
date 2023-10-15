import java.io.*
import java.util.*

const val INF = 1000000000

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (v, e, p) = readLine().split(" ").map { it.toInt() }
    val dist = IntArray(v + 1) { INF }
    val graph = ArrayList<ArrayList<Triple<Int, Int, ArrayList<Int>>>>()

    dist[1] = 0

    repeat(v + 1) { graph.add(ArrayList()) }

    repeat(e) {
        val (a, b, c) = readLine().split(" ").map { it.toInt() }

        graph[a].add(Triple(b, c, arrayListOf()))
        graph[b].add(Triple(a, c, arrayListOf()))
    }

    var isFind = false
    val pq = PriorityQueue<Triple<Int, Int, ArrayList<Int>>>(compareBy { it.second })

    pq.add(Triple(1, 0, arrayListOf(1)))

    while (pq.isNotEmpty()) {
        val now = pq.poll()

        if (now.first == v && now.third.contains(p)) isFind = true

        for (next in graph[now.first]) {
            if (dist[next.first] >= now.second + next.second) {
                val nextRoute = ArrayList<Int>()
                nextRoute.addAll(now.third)
                nextRoute.add(next.first)
                dist[next.first] = now.second + next.second
                pq.add(Triple(next.first, dist[next.first], nextRoute))
            }
        }
    }

    if (isFind) bw.write("SAVE HIM") else bw.write("GOOD BYE")

    bw.flush()
    bw.close()
}