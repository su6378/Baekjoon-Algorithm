import java.awt.Point
import java.io.*
import java.util.*

lateinit var map: Array<IntArray>
lateinit var dist: Array<IntArray>
lateinit var visited: Array<BooleanArray>
val direction = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = readLine().trim().split(" ").map { it.toInt() }

    map = Array(n) { IntArray(m) }
    dist = Array(n) { IntArray(m) { -1 } }
    visited = Array(n) { BooleanArray(m) }

    val s = Point()

    for (i in 0 until n) {
        val token = StringTokenizer(readLine())
        for (j in 0 until m) {
            map[i][j] = token.nextToken().toInt()
            if (map[i][j] == 2) {
                s.y = i
                s.x = j
                dist[i][j] = 0
            }else if (map[i][j] == 0) dist[i][j] = 0
        }
    }

    bfs(s)

    val sb = StringBuilder()

    for (i in dist.indices) {
        for (j in dist[i].indices) {
            sb.append("${dist[i][j]} ")
        }
        sb.append("\n")
    }

    bw.write(sb.toString())

    bw.flush()
    bw.close()
}

fun bfs(start: Point) {
    val q: Queue<Point> = LinkedList()
    q.offer(start)
    visited[start.y][start.x] = true
    var d = 0

    while (q.isNotEmpty()) {
        val qSize = q.size
        d++

        for (i in 0 until qSize) {
            val current = q.poll()

            for (j in 0 until 4) {
                val r = current.y + direction[j][0]
                val c = current.x + direction[j][1]

                if (r in map.indices && c in map[0].indices && !visited[r][c] && map[r][c] != 0) {
                    visited[r][c] = true
                    dist[r][c] = d
                    q.offer(Point(c, r))
                }
            }
        }
    }
}