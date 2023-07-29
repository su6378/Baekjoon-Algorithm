import java.awt.Point
import java.io.*
import java.util.*

lateinit var map: Array<CharArray>
lateinit var visited: Array<BooleanArray>
var answer = 1
val dx = intArrayOf(0, 0, -1, 1)
val dy = intArrayOf(-1, 1, 0, 0)
lateinit var pq: PriorityQueue<Int>
var aCnt = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = readLine().toInt()

    map = Array(n) { CharArray(n) }
    visited = Array(n) { BooleanArray(n) }
    pq = PriorityQueue()

    for (i in 0 until n) {
        val info = readLine()
        for (j in 0 until n) {
            map[i][j] = info[j]
        }
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (!visited[i][j] && map[i][j] == '1') bfs(Point(j, i))
        }
    }

    bw.write("$aCnt\n")

    while (pq.isNotEmpty()){
        bw.write("${pq.poll()}\n")
    }

    bw.flush()
    bw.close()
}

fun bfs(start: Point) {
    val q: Queue<Point> = LinkedList()
    var count = 1

    visited[start.y][start.x] = true
    q.offer(start)

    while (q.isNotEmpty()) {
        val cur = q.poll()

        for (i in 0 until 4) {
            val nx = cur.x + dx[i]
            val ny = cur.y + dy[i]

            if (nx in map[0].indices && ny in map.indices && !visited[ny][nx] && map[ny][nx] == '1') {
                count++
                visited[ny][nx] = true
                q.offer(Point(nx, ny))
            }
        }
    }
    pq.offer(count)
    aCnt++
}