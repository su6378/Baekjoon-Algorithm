import java.util.*
import java.io.*


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val stack = Stack<Int>()

    repeat(n) {
        val command = br.readLine().split(" ")

        if (command.contains("push")) {
            stack.push((command[1]).toInt())
        } else if (command.contains("pop")) {
            if (stack.isEmpty()) {
                bw.write("-1\n")
            } else {
                bw.write("${stack.pop()}\n")
            }
        } else if (command.contains("size")) bw.write("${stack.size}\n")
        else if (command.contains("empty")) {
            if (stack.isEmpty()) bw.write("1\n")
            else bw.write("0\n")
        }else if(command.contains("top")){
            if(stack.isEmpty()) bw.write("-1\n")
            else bw.write("${stack.peek()}\n")
         }
    }

    bw.flush()
    bw.close()

}