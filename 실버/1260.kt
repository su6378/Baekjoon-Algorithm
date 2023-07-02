import java.io.*
import java.util.*
import kotlin.collections.ArrayList

lateinit var graph: ArrayList<ArrayList<Int>>
lateinit var visited: BooleanArray
lateinit var bw: BufferedWriter
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    bw = BufferedWriter(OutputStreamWriter(System.out))

    var token = StringTokenizer(readLine())

    val n = token.nextToken().toInt()
    val m = token.nextToken().toInt()
    val v = token.nextToken().toInt()

    graph = ArrayList()

    for (i in 0..n + 1) {
        graph.add(ArrayList())
    }

    repeat(m) {
        token = StringTokenizer(readLine())
        val start = token.nextToken().toInt()
        val end = token.nextToken().toInt()
        graph[start].add(end)
        graph[end].add(start)
    }


    for (i in 1..n + 1) {
        graph[i].sort()
    }

    visited = BooleanArray(n + 1)
    dfs(v)

    bw.write("\n")

    visited = BooleanArray(n + 1)
    bfs(v)

    bw.flush()
    bw.close()
}

fun dfs(start: Int) {

    visited[start] = true
    bw.write("$start ")

    for (next in graph[start]) {
        if (!visited[next]) {
            dfs(next)
        }
    }
}

fun bfs(start: Int) {
    val queue: Queue<Int> = LinkedList()
    queue.add(start)
    visited[start] = true
    bw.write("$start ")

    while (queue.isNotEmpty()) {
        val node = queue.poll()

        for (next in graph[node]){
            if (!visited[next]){
                visited[next] = true
                bw.write("$next ")
                queue.add(next)
            }
        }
    }

}
