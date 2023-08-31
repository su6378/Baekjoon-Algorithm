import java.io.*
import java.util.*
import kotlin.math.*

const val MAX = 1000000

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = readLine().toInt()
    val arr = Array(n + 1) { IntArray(3) }

    for (i in 1..n) {
        val st = StringTokenizer(readLine())
        for (j in 0 until 3) {
            arr[i][j] = st.nextToken().toInt()
        }
    }

    val minDp = Array(n + 1) { IntArray(3) { MAX } }
    val maxDp = Array(n + 1) { IntArray(3) }

    for (i in 0 until 3) {
        minDp[1][i] = arr[1][i]
        maxDp[1][i] = arr[1][i]
    }

    if (n >= 2) {
        for (i in 2..n) {
            for (j in 0 until 3) {
                when (j) {
                    0 -> {
                        minDp[i][1] = min(minDp[i][1], minDp[i - 1][0] + arr[i][1])
                        maxDp[i][1] = max(maxDp[i][1], maxDp[i - 1][0] + arr[i][1])
                    }

                    1 -> {
                        minDp[i][0] = min(minDp[i][0], minDp[i - 1][1] + arr[i][0])
                        minDp[i][2] = min(minDp[i][2], minDp[i - 1][1] + arr[i][2])
                        maxDp[i][0] = max(maxDp[i][0], maxDp[i - 1][1] + arr[i][0])
                        maxDp[i][2] = max(maxDp[i][2], maxDp[i - 1][1] + arr[i][2])
                    }
                    2 ->{
                        minDp[i][1] = min(minDp[i][1], minDp[i - 1][2] + arr[i][1])
                        maxDp[i][1] = max(maxDp[i][1], maxDp[i - 1][2] + arr[i][1])
                    }
                }
                minDp[i][j] = min(minDp[i][j], minDp[i-1][j] + arr[i][j])
                maxDp[i][j] = max(maxDp[i][j], maxDp[i-1][j] + arr[i][j])
            }
        }
    }

    bw.write("${maxDp[n].max()} ${minDp[n].min()}")

    bw.flush()
    bw.close()
}