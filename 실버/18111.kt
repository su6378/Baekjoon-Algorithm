import java.io.*
import java.util.StringTokenizer
import kotlin.math.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var token = StringTokenizer(readLine())
    val n = token.nextToken().toInt()
    val m = token.nextToken().toInt()
    var b = token.nextToken().toInt()

    val ground = Array(n) { IntArray(m) }
    var minHeight = 256
    var maxHeight = 0

    for (i in 0 until n) {
        token = StringTokenizer(readLine())
        for (j in 0 until m) {
            ground[i][j] = token.nextToken().toInt()
            minHeight = min(minHeight, ground[i][j])
            maxHeight = max(maxHeight, ground[i][j])
        }
    }

    var minTime = Integer.MAX_VALUE
    var height = 0

    for (i in minHeight..maxHeight) {
        var delete = 0
        var insert = 0
        var block = b

        for (j in 0 until n) {
            for (k in 0 until m) {
                if (ground[j][k] < i) { // 목표 높이보다 작을 경우 블록 쌓기
                    insert += i - ground[j][k]
                    block -= i - ground[j][k]
                } else if (ground[j][k] > i) { // 목표 높이보다 높을 경우 블록 제거
                    delete += ground[j][k] - i
                    block += ground[j][k] - i
                }
            }
        }

        if (block >= 0){ // 블록의 갯수가 0보다 크거나 같으면 최소 시간 및 최대 높이 갱신
            val time = insert + (delete * 2)
            if (minTime >= time && height <= i) {
                minTime = time
                height = i
            }
        }
    }

    bw.write("$minTime $height")


    bw.flush()
    bw.close()
}
