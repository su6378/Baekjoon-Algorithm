import java.awt.Point
import java.io.*
import java.util.*

val board = Array(5) { IntArray(5) }
val dy = intArrayOf(-1, 1, 0, 0)
val dx = intArrayOf(0, 0, -1, 1)
var isFound = false

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    repeat(5) { i ->
        val token = StringTokenizer(readLine())
        repeat(5) { j ->
            board[i][j] = token.nextToken().toInt()
        }
    }

    val token = StringTokenizer(readLine())
    val r = token.nextToken().toInt()
    val c = token.nextToken().toInt()

    board[r][c] = -1
    dfs(0, Point(c, r), 0)

    if (isFound) bw.write("1") else bw.write("0")

    bw.flush()
    bw.close()
}

fun dfs(move: Int, start: Point, apple: Int) {

    if (move >= 3) {
        if (apple >= 2) isFound = true
        return
    }

    if (isFound) {
        return
    }

    for (i in 0 until 4) {
        val nextR = start.y + dy[i]
        val nextC = start.x + dx[i]

        if (nextR in 0..4 && nextC in 0..4 && board[nextR][nextC] != -1) {
            if (board[nextR][nextC] == 1) {
                if (apple + 1 == 2) {
                    isFound = true
                    return
                } else {
                    board[nextR][nextC] = -1
                    dfs(move + 1, Point(nextC, nextR), apple + 1)
                    board[nextR][nextC] = 1
                }
            } else {
                board[nextR][nextC] = -1
                dfs(move + 1, Point(nextC, nextR), apple)
                board[nextR][nextC] = 0
            }
        }
    }
}