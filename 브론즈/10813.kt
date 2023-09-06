import java.io.*
import java.util.StringTokenizer

lateinit var st: StringTokenizer
lateinit var arr: IntArray

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = readLine().split(" ").map { it.toInt() }
    arr = IntArray(n + 1) { it }

    repeat(m) {
        st = StringTokenizer(readLine())
        var a = st.nextToken().toInt()
        var b = st.nextToken().toInt()

        swap(a, b)
    }

    for (i in 1..n) {
        bw.write("${arr[i]} ")
    }


    bw.flush()
    bw.close()
}

fun swap(a: Int, b: Int) {
    var tmp = arr[a]
    var tmp2 = arr[b]

    tmp = tmp2.also { tmp2 = tmp }

    arr[a] = tmp
    arr[b] = tmp2
}