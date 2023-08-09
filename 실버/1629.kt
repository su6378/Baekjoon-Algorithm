import java.io.*
import java.util.*

lateinit var st: StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    st = StringTokenizer(readLine())
    val a = st.nextToken().toLong()
    val b = st.nextToken().toLong()
    val c = st.nextToken().toInt()

    bw.write("${pow(a, b, c)}")

    bw.flush()
    bw.close()
}

fun pow(a: Long, b: Long, c: Int): Long {
    if (b == 1L) return a % c

    var tmp = pow(a, b / 2, c)

    if (b % 2 == 1L) return (tmp * tmp % c) * a % c

    return tmp * tmp % c
}