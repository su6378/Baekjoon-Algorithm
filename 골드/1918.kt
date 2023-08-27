import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val expression = readLine()
    val stack = Stack<Char>()
    val sb = StringBuilder()

    for (c in expression) {
        when (c) {
            '(' -> stack.add(c)

            ')' -> {
                while (true) {
                    if (stack.peek() == '(') {
                        stack.pop()
                        break
                    }
                    sb.append(stack.pop())
                }
            }

            '+', '-' -> {
                if (stack.isEmpty()) stack.add(c)
                else {
                    while (stack.isNotEmpty()) {
                        if (stack.peek() == '(') break
                        sb.append(stack.pop())
                    }
                    stack.add(c)
                }
            }

            '*', '/' -> {
                if (stack.isEmpty()) stack.add(c)
                else {
                    if (stack.peek() == '*' || stack.peek() == '/') {
                        while (stack.isNotEmpty()) {
                            if (stack.peek() == '(' || stack.peek() == '-' || stack.peek() == '+') break
                            sb.append(stack.pop())
                        }
                    }
                    stack.add(c)
                }
            }

            else -> {
                sb.append(c)
            }
        }
    }

    while (stack.isNotEmpty()) {
        sb.append(stack.pop())
    }

    bw.write("$sb")

    bw.flush()
    bw.close()
}