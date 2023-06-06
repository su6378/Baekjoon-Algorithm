import java.util.*
import java.io.*
import kotlin.collections.HashMap

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val N = readLine().toInt()
    val map = HashMap<Int,Int>()

    val A = StringTokenizer(readLine())

    while (A.hasMoreTokens()){
        val aKey = A.nextToken().toInt()
        if (!map.containsKey(aKey)) map[aKey] = 1
    }

    val M = readLine().toInt()

    val numArr = StringTokenizer(readLine())

    while (numArr.hasMoreTokens()){
        val num = numArr.nextToken().toInt()
        if(map.containsKey(num)) bw.write("1\n")
        else bw.write("0\n")
    }

    bw.flush()
    bw.close()
}

