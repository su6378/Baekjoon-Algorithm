import java.util.*
import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val N = readLine().toInt()
    val queue: Queue<Int> = LinkedList()

    repeat(N) {
        val command = readLine().split(" ")

        when (command[0]) {
            "push" -> queue.offer(command[1].toInt())
            "pop" -> {
                if (queue.isEmpty()) bw.write("-1\n")
                else bw.write("${queue.poll()}\n")
            }

            "size" -> bw.write("${queue.size}\n")
            "empty" -> {
                if (queue.isEmpty()) bw.write("1\n")
                else bw.write("0\n")
            }

            "front" -> {
                if (queue.isEmpty()) bw.write("-1\n")
                else bw.write("${queue.peek()}\n")
            }

            "back" -> {
                if (queue.isEmpty()) bw.write("-1\n")
                else bw.write("${queue.last()}\n")
            }
        }
    }

    bw.flush()
    bw.close()
}

