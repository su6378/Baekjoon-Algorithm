import java.io.*
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val t = readLine().toInt()

    repeat(t){
        val st = StringTokenizer(readLine())
        val m = st.nextToken().toInt()
        val n = st.nextToken().toInt()
        val x = st.nextToken().toInt() - 1
        val y = st.nextToken().toInt() - 1

        var i = x
        var isExist = false

        while (i < n*m){
            if (i % n == y){
                bw.write("${i+1}\n")
                isExist = true
                break
            }
            i += m
        }

        if (!isExist) bw.write("-1\n")
    }
    bw.flush()
    bw.close()
}