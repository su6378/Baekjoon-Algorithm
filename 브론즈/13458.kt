import java.io.*
import java.util.StringTokenizer

lateinit var st: StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var answer = 0L
    val n = readLine().toInt()
    val a = IntArray(n)
    st = StringTokenizer(readLine())

    repeat(n) { a[it] = st.nextToken().toInt() }

    st = StringTokenizer(readLine())
    val b = st.nextToken().toInt()
    val c = st.nextToken().toInt()

    for (i in a.indices){
        var people = a[i]

        answer++

        if (people - b <= 0) continue
        people -= b

        answer += if (people % c == 0) people / c else people / c + 1
    }

    bw.write("$answer")

    bw.flush()
    bw.close()
}