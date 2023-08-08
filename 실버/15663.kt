import java.io.*
import java.util.*
import kotlin.collections.HashMap

lateinit var st: StringTokenizer
lateinit var numArr: IntArray
lateinit var bw: BufferedWriter
lateinit var visited: IntArray
lateinit var map: HashMap<String,Int>

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    bw = BufferedWriter(OutputStreamWriter(System.out))

    st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    numArr = IntArray(n)
    visited = IntArray(10001)
    map = HashMap()

    st = StringTokenizer(readLine())
    repeat(n) {
        val num = st.nextToken().toInt()
        numArr[it] = num
        visited[num]++
    }


    numArr.sort()
    comb(0, m, IntArray(m),"")

    bw.flush()
    bw.close()
}

fun comb(size: Int, m: Int, sequence: IntArray, result: String) {
    if (size == m) {
        if (!map.containsKey(result)){
            for (i in sequence.indices) {
                bw.write("${sequence[i]} ")
            }
            bw.write("\n")
            map[result] = 1
        }
        return
    }

    for (i in numArr.indices) {
        if (visited[numArr[i]] > 0){
            visited[numArr[i]]--
            sequence[size] = numArr[i]
            comb(size + 1, m, sequence, result + numArr[i].toString()+" ")
            visited[numArr[i]]++
        }
    }
}