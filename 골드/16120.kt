import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val str = readLine()
    val stack = Stack<Char>()

    for (i in str.indices) {
        if (stack.size < 3) stack.add(str[i])
        else {
            val size = stack.size
            if (str[i] == 'P' && stack[size - 3] == 'P' && stack[size - 2] == 'P' && stack[size - 1] == 'A') {
                repeat(2) { stack.pop() }
            } else stack.add(str[i])
        }
    }

    if (stack.size == 1 && stack.peek() == 'P') bw.write("PPAP")
    else bw.write("NP")

    bw.flush()
    bw.close()
}