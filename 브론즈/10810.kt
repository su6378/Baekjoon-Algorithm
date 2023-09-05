import java.io.*
import java.util.StringTokenizer

lateinit var st: StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = IntArray(n + 1)

    repeat(m){
        st = StringTokenizer(readLine())
        val s = st.nextToken().toInt()
        val e = st.nextToken().toInt()
        val v = st.nextToken().toInt()

        for (i in s..e){
            arr[i] = v
        }
    }

    for (i in 1..n){
        bw.write("${arr[i]} ")
    }


    bw.flush()
    bw.close()
}