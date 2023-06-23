import java.util.*
import java.io.*
import kotlin.math.abs

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = readLine()
    val numArr = IntArray(10)

    for (i in n.indices){
        numArr[n[i].digitToInt()]++
    }

    while (true){
        if (abs(numArr[6] - numArr[9]) <= 1) break

        if (numArr[6] > numArr[9]){
            numArr[9]++
            numArr[6]--
        }else if(numArr[6] < numArr[9]){
            numArr[9]--
            numArr[6]++
        }
    }

    bw.write("${numArr.max()}")

    bw.flush()
    bw.close()
}


