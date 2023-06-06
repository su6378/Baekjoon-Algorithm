import java.util.*
import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val L = readLine().toInt()

    val word = readLine()
    var r  = 1L
    var H : Long = 1L * (word[0].code % 96).toLong()

    for (i in 1 until L){
        r = r % 1234567891 * 31L
        H += (r * (word[i].code % 96).toLong()) % 1234567891
    }

    bw.write("${H % 1234567891}")

    bw.flush()
    bw.close()
}

