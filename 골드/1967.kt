import java.io.*
import java.util.*
import kotlin.collections.ArrayList

lateinit var st: StringTokenizer
lateinit var graph: ArrayList<ArrayList<Pair<Int, Int>>>
lateinit var checked: BooleanArray
lateinit var visited: BooleanArray
var answer = 0
var node = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = readLine().toInt()

    graph = ArrayList()
    checked = BooleanArray(n + 1) { true }

    repeat(n + 1) { graph.add(ArrayList()) }

    repeat(n - 1) {
        st = StringTokenizer(readLine())
        val s = st.nextToken().toInt()
        val e = st.nextToken().toInt()
        val c = st.nextToken().toInt()

        graph[s].add(Pair(e, c))
        graph[e].add(Pair(s, c))
        checked[s] = false
    }

    var rNode = 0

    for (i in 1..n) {
        if (checked[i]) {
            rNode = i
            break
        }
    }

    // 임의의 정점에서 가장 먼 정점 구하기
    visited = BooleanArray(n + 1)
    dfs(rNode, 0)

    // 가장 먼 정점에서 가장 먼 거리 구해서 기존의 임의의 정점에서 가장 먼 거리와 비교
    visited = BooleanArray(n + 1)
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