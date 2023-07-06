import java.io.*
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val dp = IntArray(1000001)

    dp[1] = 0
    dp[2] = 1
    dp[3] = 1

    val n = readLine().toInt()

    for (i in 4..1000000){
        var minValue = Integer.MAX_VALUE

        if (i % 3 == 0) minValue = min(minValue,dp[i/3] + 1)
        if(i % 2 == 0) minValue = min(minValue,dp[i/2] + 1)
        minValue = min(minValue,dp[i-1] + 1)

        dp[i] = minValue
    }

    bw.write("${dp[n]}")

    bw.flush()
    bw.close()
}