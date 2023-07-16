import java.io.*
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n,m) = readLine().trim().split(" ").map { it.toInt() }

    val map = HashMap<String,String>()

    repeat(n){
        val token = StringTokenizer(readLine())
        map[token.nextToken()] = token.nextToken()
    }

    repeat(m){
        val key = readLine()
        bw.write("${map[key]}\n")
    }

    bw.flush()
    bw.close()
}
