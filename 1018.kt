import java.io.*
import java.util.*


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val white = arrayOf(
        arrayOf('W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'),
        arrayOf('B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'),
        arrayOf('W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'),
        arrayOf('B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'),
        arrayOf('W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'),
        arrayOf('B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'),
        arrayOf('W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'),
        arrayOf('B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'),
    )

    val black = arrayOf(
        arrayOf('B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'),
        arrayOf('W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'),
        arrayOf('B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'),
        arrayOf('W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'),
        arrayOf('B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'),
        arrayOf('W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'),
        arrayOf('B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'),
        arrayOf('W', 'B', 'W', 'B', 'W', 'B', 'W', 'B')
    )

    val token = StringTokenizer(br.readLine())

    val n = token.nextToken().toInt()
    val m = token.nextToken().toInt()

    val board = Array(n) { CharArray(m) }
    val chess = Array(8) { CharArray(8) }
    var minCount = Int.MAX_VALUE
    var paint = 0

    for (i in 0 until n) {
        val color = br.readLine()
        for (j in 0 until m) {
            board[i][j] = color[j]
        }
    }

    for (a in 0..n - 8) {
        for (b in 0..m - 8) {
            for (c in a until a + 8) {
                for (d in b until b + 8) {
                    chess[c - a][d - b] = board[c][d]
                }
            }

            for (i in chess.indices) {
                for (j in chess[i].indices) {
                    if (chess[i][j] != white[i][j]) {
                        paint++
                    }
                }

            }
            minCount = minCount.coerceAtMost(paint)
            paint = 0

            for (i in chess.indices) {
                for (j in chess[i].indices) {
                    if (chess[i][j] != black[i][j]) {
                        paint++
                    }
                }
            }
            minCount = minCount.coerceAtMost(paint)
            paint = 0
        }


    }
    println(minCount)
}