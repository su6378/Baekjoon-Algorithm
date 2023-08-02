import java.io.*
import java.util.*

lateinit var st: StringTokenizer
lateinit var storage: Array<Array<IntArray>>
var unRipeCnt = 0
lateinit var q: Queue<Triple<Int, Int, Int>>
val dir = arrayOf(
        intArrayOf(-1, 0, 0), intArrayOf(1, 0, 0), intArrayOf(0, -1, 0),
        intArrayOf(0, 1, 0), intArrayOf(0, 0, -1), intArrayOf(0, 0, 1))

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (m, n, h) = readLine().trim().split(" ").map { it.toInt() }
    storage = Array(h) { Array(n) { IntArray(m) } }
    q = LinkedList()

    for (i in 0 until h) {
        for (j in 0 until n) {
            st = StringTokenizer(readLine())
            for (k in 0 until m) {
                storage[i][j][k] = st.nextToken().toInt()

                if (storage[i][j][k] == 1) q.offer(Triple(k, j, i))
                else if (storage[i][j][k] == 0) unRipeCnt++
            }
        }
    }

    if (unRipeCnt == 0) bw.write("0")
    else {
        val day = bfs(h, n, m)
        if (unRipeCnt == 0) bw.write("$day")
        else bw.write("-1")
    }

    bw.flush()
    bw.close()
}

fun bfs(h: Int, n: Int, m: Int): Int {
    var day = 0

    while (q.isNotEmpty()) {
        val qSize = q.size
        day++

        for (i in 0 until qSize) {
            val cur = q.poll()

            for (j in 0 until 6) {
                val nx = cur.first + dir[j][2]
                val ny = cur.second + dir[j][1]
                val nz = cur.third + dir[j][0]

                if (nx in 0 until m && ny in 0 until n && nz in 0 until h && storage[nz][ny][nx] == 0) {
                    storage[nz][ny][nx] = 1
                    unRipeCnt--
                    if (unRipeCnt == 0) return day
                    q.offer(Triple(nx, ny, nz))
                }
            }
        }
    }
    return day
}