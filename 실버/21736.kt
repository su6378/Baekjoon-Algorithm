import java.awt.Point
import java.io.*
import java.util.*

lateinit var campus: Array<CharArray>
lateinit var visited: Array<BooleanArray>
val direction = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))
var answer = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = readLine().trim().split(" ").map { it.toInt() }

    campus = Array(n) { CharArray(m) }
    visited = Array(n) { BooleanArray(m) }
    var start = Point()

    for (i in 0 until n) {
        val info = readLine()
        for (j in 0 until m) {
            campus[i][j] = info[j]
            if (campus[i][j] == 'I') {
                start.x = j
                start.y = i
            }
        }
    }

    bfs(start)

    if (answer == 0) bw.write("TT")
    else bw.write("$answer")

    bw.flush()
    bw.close()
}

fun bfs(start: Point) {
    val q: Queue<Point> = LinkedList()
    q.offer(start)
    visited[start.y][start.x] = true

    while (q.isNotEmpty()) {
        val cur = q.poll()

        for (i in 0 until 4) {
            val r = cur.y + direction[i][0]
            val c = cur.x + direction[i][1]

            if (r in campus.indices && c in campus[0].indices && !visited[r][c] && campus[r][c] != 'X') {
                if (campus[r][c] == 'P') answer++
                visited[r][c] = true
                q.offer(Point(c, r))
            }
        }
    }
}