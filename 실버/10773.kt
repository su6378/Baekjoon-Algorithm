import java.util.*
import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val k = br.readLine().toInt()
    val stack = Stack<Int>()

    repeat(k){
        val num = br.readLine().toInt()
        if(num == 0){
            stack.pop()
        }else stack.push(num)
    }

    println(stack.sum())


}