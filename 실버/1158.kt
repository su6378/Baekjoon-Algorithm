import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val token = StringTokenizer(readLine())
    val n = token.nextToken().toInt()
    val k = token.nextToken().toInt()
    val list : ArrayList<Int> = ArrayList<Int>().apply {
        repeat(n){ index ->
            add(index+1)
        }
    }

    val answer = LinkedList<Int>()
    var currentIdx = 0

    while (true){
        if (list.size == 1) {
            answer.add(list.last())
            break
        }
        else{
            var count = k
            if (list.size == n) count--
            while (count > 0){
                if (currentIdx + 1 > list.size-1) currentIdx = 0
                else currentIdx++
                count--
            }
            answer.add(list[currentIdx])
            list.removeAt(currentIdx)
            currentIdx--
        }
    }
    println("<${answer.joinToString(", ")}>")
}
