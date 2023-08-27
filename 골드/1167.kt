import java.io.*
import java.util.*
import kotlin.collections.ArrayList

lateinit var st: StringTokenizer
lateinit var graph: ArrayList<ArrayList<Pair<Int, Int>>>
lateinit var visited: BooleanArray
var answer = 0
var node = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val v = readLine().toInt()

    graph = ArrayList()

    repeat(v + 1) { graph.add(ArrayList()) }

    repeat(v) {
        st = StringTokenizer(readLine())
        val s = st.nextToken().toInt()

        while (st.hasMoreTokens()) {
            val e = st.nextToken().toInt()

            if (e == -1) break

            val c = st.nextToken().toInt()

            graph[s].add(Pair(e, c))
        }
    }

    // 임의의 정점에서 가장 먼 정점 구하기
    visited = BooleanArray(v + 1)
    dfs(1, 0)

    // 가장 먼 정점에서 가장 먼 거리 구해서 기존의 임의의 정점에서 가장 먼 거리와 비교
    visited = BooleanArray(v + 1)
    dfs(node, 0)

    bw.write("$answer")

    bw.flush()
    bw.close()
}

fun dfs(s: Int, d: Int) {

    if (d > answer) { // 가장 먼 거리 정보 갱신
        answer = d
        node = s
    }

    visited[s] = true

    for (next in graph[s]) {
        if (!visited[next.first]) {
            dfs(next.first, d + next.second)
        }
    }
}