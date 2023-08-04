import java.io.*
import java.util.*

lateinit var st: StringTokenizer
lateinit var numArr: IntArray
lateinit var visited: BooleanArray
lateinit var bw: BufferedWriter

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    bw = BufferedWriter(OutputStreamWriter(System.out))

    st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    numArr = IntArray(n)
    visited = BooleanArray(10000)

    st = StringTokenizer(readLine())
    repeat(n) {
        numArr[it] = st.nextToken().toInt()
    }

    numArr.sort()
    comb(0, m, IntArray(m))

    bw.flush()
    bw.close()
}

fun comb(size: Int, m: Int, sequence: IntArray) {
    if (size == m) {
        for (i in sequence.indices){
            bw.write("${sequence[i]} ")
        }
        bw.write("\n")
        return
    }

    for (i in numArr.indices) {
        if (!visited[numArr[i]]) {
            visited[numArr[i]] = true
            sequence[size] = numArr[i]
            comb(size + 1, m, sequence)
            visited[numArr[i]] = false
        }
    }
}