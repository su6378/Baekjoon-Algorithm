import java.io.*
import kotlin.text.StringBuilder

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val s = readLine()
    val word = StringBuilder()
    val sb = StringBuilder()
    var isTag = false

    for (i in s.indices) {
        when (s[i]) {
            '<' -> { // 태그 시작
                if (sb.isNotEmpty()) {
                    word.append(sb.reverse())
                    sb.setLength(0)
                }
                sb.append('<')
                isTag = true
            }

            '>' -> { // 태그 종료
                sb.append('>')
                isTag = false
                word.append(sb)
                sb.setLength(0)
            }

            ' ' -> { // 공백 문자
                if (!isTag) {
                    sb.reverse().append(' ')
                    word.append(sb)
                    sb.setLength(0)
                } else sb.append(' ')
            }

            else -> {
                sb.append(s[i])
            }
        }
    }

    if (!isTag) {
        word.append(sb.reverse())
    }

    bw.write("$word")

    bw.flush()
    bw.close()
}