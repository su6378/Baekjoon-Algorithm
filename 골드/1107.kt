import java.io.*
import java.util.*
import kotlin.math.*

lateinit var st: StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = readLine().toInt()
    val m = readLine().toInt()
    val broken = BooleanArray(10)

    if (m > 0){
        st = StringTokenizer(readLine())

        repeat(m) {
            broken[st.nextToken().toInt()] = true
        }
    }

    var answer = abs(n - 100)

    for (i in 0 .. 999999){
        val cur = i.toString()
        val len = cur.length

        var isBreak = false

        for (j in 0 until len){
            if (broken[cur[j].digitToInt()]){ // 고장난 버튼을 눌렀을 경우 종료
                isBreak = true
                break
            }
        }

        if (!isBreak){ // i가 고장난 버튼으로 이루어지지 않는다면
            // 버튼을 누른 횟수 + 해당 채널에서 n까지 + or - 버튼 횟수
            answer = min(answer, abs(n - i) + len)
        }
    }

    bw.write("$answer")

    bw.flush()
    bw.close()
}