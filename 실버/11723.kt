import java.util.*
import java.io.*
import kotlin.collections.LinkedHashSet

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val m = readLine().toInt()
    val set = LinkedHashSet<Int>()

    repeat(m){
        val operation = readLine()

        when(operation.split(" ")[0]){
            "add" -> set.add(operation.split(" ")[1].toInt())
            "remove" -> {
                val deleteTarget = operation.split(" ")[1].toInt()
                if (set.contains(deleteTarget)) set.remove(deleteTarget)
            }
            "check" -> {
                val checkTarget = operation.split(" ")[1].toInt()
                if (set.contains(checkTarget)) bw.write("1\n")
                else bw.write("0\n")
            }
            "toggle" -> {
                val target = operation.split(" ")[1].toInt()
                if (set.contains(target)) set.remove(target)
                else set.add(target)
            }
            "all" -> {
                set.clear()
                set.addAll(arrayOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20))
            }
            "empty" -> set.clear()
        }
    }

    bw.flush()
    bw.close()
}


