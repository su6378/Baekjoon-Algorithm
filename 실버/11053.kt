import java.io.*
import java.util.*

lateinit var st: StringTokenizer
lateinit var dp: IntArray

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = readLine().toInt()
    var len = 0
    val numArr = IntArray(n + 1)
    dp = IntArray(n + 1)

    st = StringTokenizer(readLine())

    repeat(n) { numArr[it] = st.nextToken().toInt() }

    for (i in 0 until n) {
        val idx = binarySearch(numArr[i], 0, len, len + 1)

        if (idx == -1) dp[len++] = numArr[i]
        else dp[idx] = numArr[i]
    }

    bw.write("$len")

    bw.flush()
    bw.close()
}

fun binarySearch(num: Int, start: Int, end: Int, size: Int): Int {
    var idx = 0
    var s = start
    var e = end

    while (s <= e) {
        val mid = (s + e) / 2

        if (num <= dp[mid]) { // 교환할 위치를 찾음
            idx = mid
            e = mid - 1
        } else s = mid + 1
    }

    return if (s == size) -1
    else idx
}