import java.util.*
import java.io.*
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var token = StringTokenizer(readLine())

    val n = token.nextToken().toInt()
    val m = token.nextToken().toInt()

    val paper = Array(n) { IntArray(m) }

    for (i in 0 until n) {
        token = StringTokenizer(readLine())
        for (j in 0 until m) {
            paper[i][j] = token.nextToken().toInt()
        }
    }

    var answer = 0
    var sum = 0

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (i + 1 < n && j + 1 < m) {
                sum = paper[i][j] + paper[i + 1][j] + paper[i][j + 1] + paper[i + 1][j + 1]
                answer = max(answer, sum)
            }
            if (i + 3 < n) {
                sum = paper[i][j] + paper[i + 1][j] + paper[i + 2][j] + paper[i + 3][j]
                answer = max(answer, sum)
            }

            if (j + 3 < m) {
                sum = paper[i][j] + paper[i][j + 1] + paper[i][j + 2] + paper[i][j + 3]
                answer = max(answer, sum)
            }

            if (i + 2 < n && j + 1 < m) {
                val sum1 = paper[i][j] + paper[i + 1][j] + paper[i + 2][j] + paper[i + 2][j + 1]
                val sum2 = paper[i][j] + paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 2][j + 1]
                val sum3 = paper[i][j] + paper[i+1][j] + paper[i+1][j+1] + paper[i+2][j]
                val sum4 = paper[i][j] + paper[i][j+1] + paper[i+1][j] + paper[i+2][j]
                val sum5 = paper[i][j] + paper[i][j+1] + paper[i+1][j+1] + paper[i+2][j+1]
                sum = max(sum1,max(sum2, max(sum3, max(sum4,sum5))))
                answer = max(answer, sum)
            }

            if (i + 1 < n && j + 2 < m) {
                val sum1 = paper[i][j] + paper[i + 1][j] + paper[i][j + 1] + paper[i][j + 2]
                val sum2 = paper[i][j] + paper[i][j+1] + paper[i][j+2] + paper[i+1][j+2]
                sum = max(sum1,sum2)
                answer = max(answer, sum)
            }

            if (i + 2 < n && j - 1 >= 0) {
                val sum1 = paper[i][j] + paper[i + 1][j] + paper[i + 2][j] + paper[i + 2][j - 1]
                val sum2 = paper[i][j] + paper[i+1][j] + paper[i+1][j-1] + paper[i+2][j-1]
                val sum3 = paper[i][j] + paper[i+1][j] + paper[i+1][j-1] + paper[i+2][j]
                sum = max(sum1,max(sum2,sum3))
                answer = max(answer, sum)
            }

            if (i + 1 < n && j + 2 < m) {
                val sum1 = paper[i][j] + paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 1][j + 2]
                val sum2 = paper[i][j] + paper[i][j + 1] + paper[i + 1][j + 1] + paper[i + 1][j + 2]
                val sum3 = paper[i][j] + paper[i][j+1] + paper[i][j+2] + paper[i+1][j+1]
                sum = max(sum1,max(sum2,sum3))
                answer = max(answer, sum)
            }

            if(i + 1 < n && j - 1 >= 0 && j + 1 < m){
                val sum1 = paper[i][j] + paper[i][j+1] + paper[i+1][j] + paper[i+1][j-1]
                val sum2 = paper[i][j] + paper[i+1][j] + paper[i+1][j-1] + paper[i+1][j+1]
                sum = max(sum1,sum2)
                answer = max(answer, sum)
            }

            if (i + 1 < n && j - 2 >= 0){
                sum = paper[i][j] + paper[i+1][j] + paper[i+1][j-1] + paper[i+1][j-2]
                answer = max(answer, sum)
            }
        }
    }

    bw.write("$answer")

    bw.flush()
    bw.close()
}


