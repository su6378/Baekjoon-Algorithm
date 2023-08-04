import java.io.*
import java.util.*
import kotlin.collections.HashMap

lateinit var st: StringTokenizer
lateinit var map: HashMap<Int, Int>

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val t = readLine().toInt()

    repeat(t) {
        val k = readLine().toInt()
        val minPq = PriorityQueue<Int>()
        val maxPq = PriorityQueue<Int>(Collections.reverseOrder())
        map = HashMap()

        repeat(k) {
            st = StringTokenizer(readLine())

            when (st.nextToken()) {
                "I" -> {
                    val num = st.nextToken().toInt()
                    maxPq.add(num)
                    minPq.add(num)
                    map[num] = map.getOrDefault(num, 0) + 1
                }

                "D" -> {
                    val op = st.nextToken().toInt()
                    if (map.size != 0) {
                        when (op) {
                            1 -> delete(maxPq)
                            -1 -> delete(minPq)
                        }
                    }
                }
            }
        }
        if (map.size == 0) bw.write("EMPTY\n")
        else {
            var result = delete(maxPq)
            bw.write("$result ")
            if (map.size > 0) result = delete(minPq) // 최대값과 최솟값이 일치하지 않을 때
            bw.write("$result\n")
        }
    }
    bw.flush()
    bw.close()
}

fun delete(q: PriorityQueue<Int>): Int {
    var result: Int

    while (true) {
        result = q.poll()
        val cnt = map.getOrDefault(result, 0)
        if (cnt == 0) continue

        if (cnt == 1) map.remove(result)
        else map[result] = cnt - 1
        break
    }
    return result
}