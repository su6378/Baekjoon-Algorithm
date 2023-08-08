import java.io.*
import java.util.*

lateinit var st: StringTokenizer
lateinit var numArr: IntArray
lateinit var bw: BufferedWriter
lateinit var set: TreeSet<Int>

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    bw = BufferedWriter(OutputStreamWriter(System.out))

    st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    set = TreeSet()

    st = StringTokenizer(readLine())
    repeat(n) {
        set.add(st.nextToken().toInt())
    }

    numArr = set.toIntArray()
    comb(0, m, IntArray(m),0)

    bw.flush()
    bw.close()
}

fun comb(size: Int, m: Int, sequence: IntArray, before: Int) {
    if (size == m) {
        for (i in sequence.indices) {
            bw.write("${sequence[i]} ")
        }
        bw.write("\n")
        return
    }

    for (i in numArr.indices) {
        if (before <= numArr[i]){
            sequence[size] = numArr[i]
            comb(size + 1, m, sequence, numArr[i])
        }
    }
}