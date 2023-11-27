import java.io.*
import java.util.StringTokenizer
import kotlin.math.abs

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = readLine().toInt()
    val solutions = IntArray(n)
    val st = StringTokenizer(readLine())

    repeat(n) { solutions[it] = st.nextToken().toInt() }

    solutions.sort()

    val answer = IntArray(2)
    var start = 0
    var end = n - 1
    var minSum = Integer.MAX_VALUE // 0에 가장 가까운 특성값

    while (start < end) {
        val sum = solutions[start] + solutions[end] // 특성값

        if (abs(sum) < minSum) {
            minSum = abs(sum)
            answer[0] = solutions[start]
            answer[1] = solutions[end]
        }

        if (sum > 0) end-- // 산성용액값을 낮춤
        else start++ // 알칼리성용액값 낮춤
    }

    bw.write("${answer[0]} ${answer[1]}")

    bw.flush()
    bw.close()
}