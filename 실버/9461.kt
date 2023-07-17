import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val t = readLine().toInt()

    val dp = LongArray(101)

    dp[1] = 1L
    dp[2] = 1L
    dp[3] = 1L

    for (i in 4 .. 100){
        dp[i] = dp[i-3] + dp[i-2]
    }

    repeat(t){
        bw.write("${dp[readLine().toInt()]}\n")
    }

    bw.flush()
    bw.close()
}