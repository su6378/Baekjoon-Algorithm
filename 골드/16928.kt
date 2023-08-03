import java.io.*
import java.util.*

lateinit var st: StringTokenizer
lateinit var item: IntArray
lateinit var visited: BooleanArray

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = readLine().trim().split(" ").map { it.toInt() }

    item = IntArray(101)
    visited = BooleanArray(101)

    repeat(n + m) {
        st = StringTokenizer(readLine())
        item[st.nextToken().toInt()] = st.nextToken().toInt()
    }

    bw.write("${move(0,1)}")

    bw.flush()
    bw.close()
}

fun move(cnt: Int, cur: Int) : Int{
    val q: Queue<Pair<Int, Int>> = LinkedList()
    q.add(Pair(cnt, cur))
    visited[cur] = true

    while (q.isNotEmpty()) {
        val qSize = q.size

        for (a in 0 until qSize) {
            val info = q.poll()
            val curCnt = info.first
            val curNum = info.second

            for (i in 1..6) {
                val nextNum = if (item[curNum + i] == 0) curNum + i else item[curNum + i]
                if (nextNum < 100) {
                    if (!visited[nextNum]) {
                        visited[nextNum] = true
                        q.add(Pair(curCnt + 1, nextNum))
                    }
                } else {
                    return curCnt + 1
                }
            }

        }
    }
    return -1
}