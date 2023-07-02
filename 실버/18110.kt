import java.io.*
import kotlin.math.roundToInt

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val levelList = ArrayList<Int>()
    val n = readLine().toInt()

    if(n == 0) bw.write("0")
    else{
        repeat(n) {
            levelList.add(readLine().toInt())
        }

        levelList.sort()

        val exemption = (n.toDouble() * 15.0 / 100.0).roundToInt()

        bw.write("${levelList.subList(exemption, levelList.size-exemption).average().roundToInt()}")
    }

    bw.flush()
    bw.close()
}
