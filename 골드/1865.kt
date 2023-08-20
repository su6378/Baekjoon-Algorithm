import java.io.*
import java.util.*

lateinit var st: StringTokenizer
lateinit var road: ArrayList<ArrayList<Pair<Int, Int>>>
const val INF = 987654321

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val tc = readLine().toInt()

    repeat(tc) {
        st = StringTokenizer(readLine())
        val n = st.nextToken().toInt()
        val m = st.nextToken().toInt()
        val w = st.nextToken().toInt()


        road = ArrayList()

        repeat(n + 1) { road.add(ArrayList()) }

        repeat(m) {
            st = StringTokenizer(readLine())
            val s = st.nextToken().toInt()
            val e = st.nextToken().toInt()
            val t = st.nextToken().toInt()

            road[s].add(Pair(e, t))
            road[e].add(Pair(s, t))
        }

        repeat(w) {
            st = StringTokenizer(readLine())
            val s = st.nextToken().toInt()
            val e = st.nextToken().toInt()
            val t = st.nextToken().toInt()

            road[s].add(Pair(e, -t))
        }

        if (bellmanFord(n)) bw.write("YES\n")
        else bw.write("NO\n")
    }

    bw.flush()
    bw.close()
}

fun bellmanFord(n: Int): Boolean {
    val dist = IntArray(n + 1) { INF }
    var isUpdate = false

    dist[1] = 0

    for (i in 1 until n) {
        isUpdate = false
        for (j in 1..n) {
            for (next in road[j]) {
                if (dist[next.first] > dist[j] + next.second){
                    dist[next.first] = dist[j] + next.second
                    isUpdate = true
                }
            }
        }

        if (!isUpdate) break
    }

    if (isUpdate) {
        for (i in 1..n) {
            for (next in road[i]) {
                if (dist[next.first] > dist[i] + next.second) {
                    return true
                }
            }
        }
    }
    return false
}