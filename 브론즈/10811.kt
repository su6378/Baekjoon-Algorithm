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
        val s = st.nextToken().toInt()
        val e = st.nextToken().toInt()

        reverseArr(s, e)
    }

    for (i in 1..n){
        bw.write("${arr[i]} ")
    }

    bw.flush()
    bw.close()
}

fun reverseArr(s: Int, e: Int) {
    val tempArr = IntArray(e - s + 1)

    for (i in tempArr.indices) {
        tempArr[i] = arr[e - i]
    }

    var idx = 0

    for (i in s..e){
        arr[i] = tempArr[idx++]
    }
}