import java.io.*
import java.util.StringTokenizer

lateinit var graph: ArrayList<ArrayList<Int>>
lateinit var visited : BooleanArray

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n,m) = readln().trim().split(" ").map { it.toInt() }

    visited = BooleanArray(n+1)
    graph = ArrayList()

    for (i in 0 .. n){
        graph.add(ArrayList())
    }

    repeat(m){
        val token = StringTokenizer(readLine())
        val s = token.nextToken().toInt()
        val e = token.nextToken().toInt()
        graph[s].add(e)
        graph[e].add(s)
    }

    var answer = 0

    for (i in 1..n){
        if (!visited[i]) {
            dfs(i)
            answer++
        }
    }

    bw.write("$answer")

    bw.flush()
    bw.close()
}

fun dfs(start : Int){
    visited[start] = true

    for (next in graph[start]){
        if (!visited[next]){
            dfs(next)
        }
    }
}