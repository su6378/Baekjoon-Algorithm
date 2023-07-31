import java.io.*

lateinit var table: IntArray

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = readLine().toInt()
    val m = readLine().toInt()
    val s = readLine()

    val sb = StringBuilder()
    sb.append('I')

    repeat(n) {
        sb.append("OI")
    }

    val p = sb.toString()

    makeTable(p, 2 * n + 1)

    bw.write("${find(s, p, m, 2 * n + 1)}")

    bw.flush()
    bw.close()
}

fun makeTable(pattern: String, pLen: Int) {
    table = IntArray(pLen)
    var idx = 0

    /* index > 0 => 문자열 매칭이 시작됨
	연속으로 일치하지 않으면 index 값을 돌려주어 다시 매칭 시작 */
    for (i in 1 until pLen) {
        while (idx > 0 && pattern[i] != pattern[idx]) {
            idx = table[idx - 1]
        }

        if (pattern[i] == pattern[idx]) {
            table[i] = ++idx
        }
    }
}

fun find(str: String, pattern: String, sLen: Int, pLen: Int) : Int {
    var idx = 0
    var cnt = 0

    for (i in 0 until sLen) {
        while (idx > 0 && str[i] != pattern[idx]) {
            idx = table[--idx]
        }

        if (str[i] == pattern[idx]) {
            if (idx == pLen - 1) {
                idx = table[idx]
                cnt++
            } else idx++
        }
    }
    return cnt
}