import java.io.*
import java.util.StringTokenizer

lateinit var paper: Array<IntArray>
lateinit var checked: Array<BooleanArray>
lateinit var answer: IntArray

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = readLine().toInt()

    paper = Array(n) { IntArray(n) }
    checked = Array(n) { BooleanArray(n) }
    answer = IntArray(2)

    for (i in paper.indices) {
        val token = StringTokenizer(readLine())
        for (j in paper[i].indices) {
            paper[i][j] = token.nextToken().toInt()
        }
    }

    var interval = n

    while (interval > 0) {
        for (i in 0 until n step interval) {
            for (j in 0 until n step interval) {
                if (!checked[i][j]) check(i, j, interval)
            }
        }
        interval /= 2
    }


    bw.write("${answer[0]}\n")
    bw.write("${answer[1]}")

    bw.flush()
    bw.close()
}

fun check(r: Int, c: Int, s: Int): Boolean {
    var isWhite = false
    var isBlue = false

    for (i in r until r + s) {
        for (j in c until c + s) {
            if (paper[i][j] == 0) isWhite = true
            else isBlue = true

            if (isWhite && paper[i][j] == 1) return false
            if (isBlue && paper[i][j] == 0) return false
        }
    }

    for (i in r until r + s) {
        for (j in c until c + s) {
            checked[i][j] = true
        }
    }

    if (isWhite) answer[0]++
    else answer[1]++

    return true
}