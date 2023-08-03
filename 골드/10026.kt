import java.awt.Point
import java.io.*
import java.util.*

lateinit var area: Array<CharArray>
lateinit var visited: Array<BooleanArray>
val dir = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = readLine().toInt()
    area = Array(n) { CharArray(n) }

    repeat(n) { i ->
        val info = readLine()
        repeat(n) { j ->
            area[i][j] = info[j]
        }
    }

    var isColorWeak = false
    val answer = IntArray(2)

    repeat(2) {
        visited = Array(n) { BooleanArray(n) }
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (!visited[i][j]) {
                    bfs(isColorWeak, area[i][j], Point(j, i), n)
                    answer[it]++
                }
            }
        }
        isColorWeak = true
    }

    bw.write("${answer[0]} ${answer[1]}")

    bw.flush()
    bw.close()
}

fun bfs(isColorWeak: Boolean, color: Char, start: Point, n: Int) {
    val q: Queue<Point> = LinkedList()
    visited[start.y][start.x] = true
    q.add(start)

    while (q.isNotEmpty()) {
        val cur = q.poll()

        for (i in 0 until 4) {
            val nx = cur.x + dir[i][1]
            val ny = cur.y + dir[i][0]

            if (nx in 0 until n && ny in 0 until n && !visited[ny][nx]) {
                if (isColorWeak) { // 적록색약인 사람
                    if (color == 'R' || color == 'G') {
                        if (area[ny][nx] == 'R' || area[ny][nx] == 'G') {
                            visited[ny][nx] = true
                            q.add(Point(nx, ny))
                        }
                    } else {
                        if (area[ny][nx] == color) {
                            visited[ny][nx] = true
                            q.add(Point(nx, ny))
                        }
                    }
                } else { // 적록색약이 아닌 사람
                    if (area[ny][nx] == color) {
                        visited[ny][nx] = true
                        q.add(Point(nx, ny))
                    }
                }
            }
        }
    }
}


