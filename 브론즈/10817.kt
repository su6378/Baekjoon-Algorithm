import java.util.*
import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val token = StringTokenizer(readLine())

    val numArr = IntArray(3)

    repeat(3){
        numArr[it] = token.nextToken().toInt()
    }

    numArr.sort()

    bw.write("${numArr[1]}")

    bw.flush()
    bw.close()
}

