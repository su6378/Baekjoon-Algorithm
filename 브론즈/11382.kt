import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val st = StringTokenizer(readLine())
    bw.write("${st.nextToken().toLong() + st.nextToken().toLong() + st.nextToken().toLong()}")

    bw.flush()
    bw.close()
}