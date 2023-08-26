import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val str = readLine()
    val pattern = readLine()
    val len = pattern.length
    val stack = Stack<Char>()

    for (i in str.indices) {
        stack.add(str[i])

        if (stack.size >= len){
            var isFind = true

            for (j in 0 until len) {
                if (stack[stack.size - len + j] != pattern[j]) {
                    isFind = false
                    break
                }
            }

            if (isFind) {
                repeat(len) { stack.pop() }
            }
        }
    }

    if (stack.isEmpty()) bw.write("FRULA")
    else {
        val sb = StringBuilder()

        for (i in stack.indices){
            sb.append(stack[i])
        }

        bw.write("$sb")
    }

    bw.flush()
    bw.close()
}