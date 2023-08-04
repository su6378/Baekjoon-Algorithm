import java.io.*
import java.util.*

lateinit var st: StringTokenizer
lateinit var visited: BooleanArray
lateinit var command: Array<String>

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val t = readLine().toInt()

    repeat(t) {
        st = StringTokenizer(readLine())
        visited = BooleanArray(10000)

        val start = st.nextToken().toInt()
        val end = st.nextToken().toInt()

        bfs(start, end)

        bw.write("${command[end]}\n")

    }
    bw.flush()
    bw.close()
}

fun bfs(start: Int, end: Int) {
    val q: Queue<Int> = LinkedList()
    command = Array(10000){""}

    q.add(start)
    visited[start] = true

    while (q.isNotEmpty()) {
        val info = q.poll()

        if (visited[end]) return

        val d = 2 * info % 10000
        val s = if (info == 0) 9999 else info - 1
        val l = (info % 1000) * 10 + info / 1000
        val r = (info % 10) * 1000 + info / 10

        if (!visited[d]){
            visited[d] = true
            q.add(d)
            command[d] = command[info] + "D"
        }

        if (!visited[s]){
            visited[s] = true
            q.add(s)
            command[s] = command[info] + "S"
        }

        if (!visited[l]){
            visited[l] = true
            q.add(l)
            command[l] = command[info] + "L"
        }

        if (!visited[r]){
            visited[r] = true
            q.add(r)
            command[r] = command[info] + "R"
        }
    }
}