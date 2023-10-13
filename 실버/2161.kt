import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = readLine().toInt()
    val deque = ArrayDeque<Int>()

    repeat(n) { deque.addLast(it + 1) }

    var isDelete = false

    while (deque.isNotEmpty()) {
        isDelete = if (!isDelete) {
            bw.write("${deque.removeFirst()} ")
            true
        } else {
            deque.addLast(deque.removeFirst())
            false
        }
    }

    bw.flush()
    bw.close()
}