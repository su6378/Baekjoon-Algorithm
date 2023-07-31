import java.io.*
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = readLine().toInt()
    val graph = Array(n) { IntArray(n) }

    repeat(n) { i ->
        val st = StringTokenizer(readLine())
        repeat(n) { j ->
            if (st.nextToken() == "1") {
                graph[i][j] = 1
            }
        }
    }

    // Floyd-Warshall
    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (graph[i][j] == 0 && graph[i][k] == 1 && graph[k][j] == 1) graph[i][j] = 1
            }
        }
    }

    val sb = StringBuilder()

    for (i in 0 until n) {
        for (j in 0 until n){
            sb.append("${graph[i][j]} ")
        }
        sb.append("\n")
    }

    bw.write("$sb")

    bw.flush()
    bw.close()
}