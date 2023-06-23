import java.util.*
import java.io.*

var wheels = Array(4) { IntArray(8) }

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    for (i in 0 until 4) {
        val info = readLine()
        for (j in info.indices) {
            wheels[i][j] = info[j].digitToInt()
        }
    }

    val count = readLine().toInt()

    repeat(count) {
        val token = StringTokenizer(readLine())
        val wheel = token.nextToken().toInt()
        var direction = token.nextToken().toInt()

        var oneRight = wheels[0][2]
        var twoLeft = wheels[1][6]
        var twoRight = wheels[1][2]
        var threeLeft = wheels[2][6]
        var threeRight = wheels[2][2]
        var fourLeft = wheels[3][6]

        rotate(wheel - 1, direction)

        when (wheel) {
            1 -> {
                if (oneRight != twoLeft) { // 서로 극이 다르면
                    rotate(1, direction * -1)
                    if (twoRight != threeLeft) {
                        rotate(2, direction)
                        if (threeRight != fourLeft) rotate(3, direction * -1)
                    }
                }
            }

            2 -> {
                if (twoLeft != oneRight) rotate(0, direction * -1)
                if (twoRight != threeLeft) {
                    rotate(2, direction * -1)
                    if (threeRight != fourLeft) rotate(3, direction)
                }
            }

            3 -> {
                if (threeRight != fourLeft) rotate(3, direction * -1)
                if (threeLeft != twoRight) {
                    rotate(1, direction * -1)
                    if (twoLeft != oneRight) rotate(0, direction)
                }
            }

            4 -> {
                if (fourLeft != threeRight) {
                    rotate(2, direction * -1)
                    if (threeLeft != twoRight) {
                        rotate(1, direction)
                        if (twoLeft != oneRight) rotate(0, direction * -1)
                    }
                }
            }
        }
    }

    var score = 0

    for (i in 0 until 4) { // 점수 계산
        if (wheels[i][0] == 1) {
            when (i) {
                0 -> score += 1
                1 -> score += 2
                2 -> score += 4
                3 -> score += 8
            }
        }
    }

    bw.write("$score")

    bw.flush()
    bw.close()
}

fun rotate(wheel: Int, direction: Int) { // 회전시키는 함수
    if (direction == 1) { // 시계 방향
        val temp = wheels[wheel][7]
        for (i in 7 downTo 1) {
            wheels[wheel][i] = wheels[wheel][i - 1]
        }
        wheels[wheel][0] = temp
    } else { // 반시계 방향
        val temp = wheels[wheel][0]
        for (i in 0 until 7) {
            wheels[wheel][i] = wheels[wheel][i + 1]
        }
        wheels[wheel][7] = temp
    }
}