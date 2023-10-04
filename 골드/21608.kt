import java.io.*
import java.util.*
import kotlin.math.pow

data class Seat(val point: Int, val nearCnt: Int, val likeCnt: Int)

val dx = intArrayOf(0, 0, -1, 1)
val dy = intArrayOf(-1, 1, 0, 0)
var answer = 0
var n = 0
lateinit var st: StringTokenizer
lateinit var seats: Array<IntArray>
lateinit var likes: Array<IntArray>
lateinit var pq: PriorityQueue<Seat>

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    n = readLine().toInt()
    seats = Array(n) { IntArray(n) }
    likes = Array(n * n + 1) { IntArray(4) }

    // 정렬 순서 - 인접한 좋아하는 학생 수 -> 인접한 비어있는 칸 수 -> 위쪽 왼쪽 좌표순
    pq = PriorityQueue(compareByDescending<Seat> { it.likeCnt }.thenByDescending { it.nearCnt }.thenByDescending { it.point })

    repeat(n * n) {
        st = StringTokenizer(readLine())
        val student = st.nextToken().toInt()

        repeat(4) { i ->
            likes[student][i] = st.nextToken().toInt()
        }

        assignSeat(student, likes[student])
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            getSatisfaction(seats[i][j], j, i)
        }
    }

    bw.write("$answer")

    bw.flush()
    bw.close()
}

fun assignSeat(student: Int, like: IntArray) {
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (seats[i][j] != 0) continue

            var nearCnt = 0
            var likeCnt = 0

            for (k in 0..3) {
                val nx = j + dx[k]
                val ny = i + dy[k]

                // 범위 체크
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue

                // 비어있는 칸 수 체크
                if (seats[ny][nx] == 0) nearCnt++

                // 좋아하는 학생 수 체크
                if (seats[ny][nx] == like[0]) likeCnt++
                if (seats[ny][nx] == like[1]) likeCnt++
                if (seats[ny][nx] == like[2]) likeCnt++
                if (seats[ny][nx] == like[3]) likeCnt++
            }

            pq.add(Seat(i * n + j, nearCnt, likeCnt))
        }
    }

    val x = pq.peek().point % n
    val y = pq.peek().point / n

    seats[y][x] = student // 자리 배정
    pq.clear()
}

fun getSatisfaction(student: Int, x: Int, y: Int) {
    var likeCnt = 0

    for (i in 0..3) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue

        // 좋아하는 학생 수 체크
        if (seats[ny][nx] == likes[student][0] || seats[ny][nx] == likes[student][1]
                || seats[ny][nx] == likes[student][2] || seats[ny][nx] == likes[student][3]) {
            likeCnt++
        }
    }

    if (likeCnt > 0) answer += 10.0.pow((likeCnt - 1).toDouble()).toInt()
}