import java.util.*
import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var token = StringTokenizer(readLine())
    val n = token.nextToken().toInt()
    val m = token.nextToken().toInt()

    val array = Array(n){IntArray(m)}
    val dp = Array(n){IntArray(m)}

    for (i in 0 until n){
        token = StringTokenizer(readLine())
        for (j in 0 until m){
            array[i][j] = token.nextToken().toInt()
            if (j == 0) dp[i][j] = array[i][j]
            else dp[i][j] = array[i][j] + dp[i][j-1]
        }
    }

    val k = readLine().toInt()

    repeat(k){
        token = StringTokenizer(readLine())
        val i = token.nextToken().toInt()
        val j = token.nextToken().toInt()
        val x = token.nextToken().toInt()
        val y = token.nextToken().toInt()

        var sum = 0

        for (row in i-1 until x){
            for(col in j-1 until y){
                sum += array[row][col]
            }
        }

        bw.write("$sum\n")
    }

    bw.flush()
    bw.close()
}