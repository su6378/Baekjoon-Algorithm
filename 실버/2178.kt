import java.awt.Point
import java.io.*
import java.util.*

lateinit var maze: Array<CharArray>
lateinit var visited: Array<BooleanArray>
var answer = 1
val dx = intArrayOf(0, 0, -1, 1)
val dy = intArrayOf(-1, 1, 0, 0)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = readLine().trim().split(" ").map { it.toInt() }

    maze = Array(n) { CharArray(m) }
    visited = Array(n) { BooleanArray(m) }

    for (i in 0 until n) {
        val info = readLine()
        for (j in 0 until m) {
            maze[i][j] = info[j]
        }
    }

    bfs(n, m)

    bw.write("$answer")

    bw.flush()
    bw.close()
}

fun bfs(n: Int, m: Int) {
    val q: Queue<Point> = LinkedList()

    visited[0][0] = true
    q.offer(Point(0, 0))

    while (q.isNotEmpty()) {
        val qSize = q.size
        answer++

        for (i in 0 until qSize) {
            val cur = q.poll()

            for (j in 0 until 4) {
                val nx = cur.x + dx[j]
                val ny = cur.y + dy[j]

                if (nx in maze[0].indices && ny in maze.indices && !visited[ny][nx] && maze[ny][nx] == '1') {
                    if (ny == n-1 && nx == m-1) return
                    visited[ny][nx] = true
                    q.offer(Point(nx, ny))
                }
            }
        }
    }
}