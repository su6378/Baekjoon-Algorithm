import java.io.*
import java.util.*

lateinit var graph : ArrayList<ArrayList<Int>>
lateinit var answer : Pair<Int,Int>
lateinit var visited : BooleanArray

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = readLine().trim().split(" ").map { it.toInt() }

    graph = ArrayList()
    answer = Pair(Integer.MAX_VALUE,Integer.MAX_VALUE)

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

    for (i in 1 .. n){
        visited = BooleanArray(n+1)
        bfs(i)
    }

    bw.write("${answer.first}")

    bw.flush()
    bw.close()
}

fun bfs(start : Int){
    val q : Queue<Int> = LinkedList()
    var count = 0
    var sum = 0

    visited[start] = true
    q.offer(start)

    while (q.isNotEmpty()){
        count++
        val qSize = q.size

        for (i in 0 until qSize){
            val cur = q.poll()

            for (next in graph[cur]){
                if (!visited[next]){
                    sum += count
                    visited[next] = true
                    q.offer(next)
                }
            }
        }
    }

    if (answer.second > sum) answer = Pair(start,sum)
    else if (answer.second == sum && answer.first > answer.second) answer = Pair(start,sum)

}