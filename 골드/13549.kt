import java.io.*
import java.util.*
import kotlin.math.min

lateinit var timeArr: IntArray

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, k) = readLine().split(" ").map { it.toInt() }

    timeArr = IntArray(200000) { Integer.MAX_VALUE }

    bw.write("${move(n, k)}")

    bw.flush()
    bw.close()
}

fun move(n: Int, k: Int): Int {
    val q: Queue<Pair<Int, Int>> = LinkedList()
    var time = Integer.MAX_VALUE

    q.add(Pair(n, 0))
    timeArr[n] = 0

    while (q.isNotEmpty()) {
        val cur = q.poll()

        if (cur.first == k) time = min(time, timeArr[cur.first])

        for (i in 0 until 3) {
            when (i) {
                0 -> { // X-1
                    if (cur.first - 1 >= 0 && cur.second + 1 < time && cur.second + 1 < timeArr[cur.first - 1]) {
                        timeArr[cur.first - 1] = cur.second + 1
                        q.add(Pair(cur.first - 1, cur.second + 1))
                    }
                }

                1 -> {
                    if (cur.first + 1 <= 100000 && cur.second + 1 < time && cur.second + 1 < timeArr[cur.first + 1]) {
                        timeArr[cur.first + 1] = cur.second + 1
                        q.add(Pair(cur.first + 1, cur.second + 1))
                    }
                }

                2 -> {
                    if (cur.first * 2 < 200000 && cur.second + 1 < time && cur.second < timeArr[cur.first * 2]) {
                        timeArr[cur.first * 2] = cur.second
                        q.add(Pair(cur.first * 2, cur.second))
                    }
                }
            }
        }
    }
    return time
}