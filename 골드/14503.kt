import java.awt.Point
import java.util.*
import java.io.*

lateinit var cleaned: Array<BooleanArray>
val dy = intArrayOf(-1, 0, 1, 0)
val dx = intArrayOf(0, 1, 0, -1)
var answer = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var token = StringTokenizer(readLine())

    val n = token.nextToken().toInt()
    val m = token.nextToken().toInt()

    var room = Array(n) { IntArray(m) }
    cleaned = Array(n) { BooleanArray(m) }

    token = StringTokenizer(readLine())
    val robotR = token.nextToken().toInt()
    val robotC = token.nextToken().toInt()
    val robotD = token.nextToken().toInt()

    for (i in 0 until n) {
        token = StringTokenizer(readLine())
        for (j in 0 until m) {
            room[i][j] = token.nextToken().toInt()
        }
    }

    // 시작 위치 청소
    cleaned[robotR][robotC] = true
    answer++

    dfs(robotR, robotC, robotD, room)

    bw.write("$answer")

    bw.flush()
    bw.close()
}

fun dfs(r: Int, c: Int, d: Int, room: Array<IntArray>) {
    var direction = d

    for (i in 0 until 4) { // 반시계 방향으로 돌면서 찾기
        direction--
        if (direction == -1) direction = 3

        val nextR = r + dy[direction]
        val nextC = c + dx[direction]

        if (nextR in room.indices && nextC in room[0].indices && room[nextR][nextC] == 0 && !cleaned[nextR][nextC]) {
            cleaned[nextR][nextC] = true
            answer++
            dfs(nextR, nextC, direction, room)
            return
        }
    }

    // 찾지 못하면 후진
    val backR = r - dy[direction]
    val backC = c - dx[direction]

    if (backR in room.indices && backC in room[0].indices && room[backR][backC] == 0) {
        dfs(backR, backC, direction, room)
    }
}

