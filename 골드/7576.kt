import java.awt.Point
import java.io.*
import java.util.*
import kotlin.collections.ArrayList

lateinit var farm: Array<IntArray>
lateinit var dist: Array<IntArray>
lateinit var visited: Array<BooleanArray>
val direction = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))
var count = 0
var tCount = 0
var answer = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (m, n) = readLine().trim().split(" ").map { it.toInt() }

    farm = Array(n) { IntArray(m) }
    dist = Array(n) { IntArray(m) {Integer.MAX_VALUE} }

    val sList = ArrayList<Point>()
    tCount = n * m

    for (i in 0 until n){
        val token = StringTokenizer(readLine())
        for (j in 0 until m){
            farm[i][j] = token.nextToken().toInt()
            if (farm[i][j] == 1){
                dist[i][j] = 0
                count++
                sList.add(Point(j,i))
            }else if(farm[i][j] == -1) {
                dist[i][j] = -1
                tCount--
            }
        }
    }

    if (count == tCount) bw.write("0") // -1을 제외하고 모든 토마토가 익었을 때
    else{
        visited = Array(n){ BooleanArray(m) }
        bfs(sList)

        if (count != tCount) bw.write("-1")
        else bw.write("$answer")
    }

    bw.flush()
    bw.close()
}

fun bfs(startList : ArrayList<Point>){
    val q : Queue<Point> = LinkedList()
    var day = 0

    for (start in startList){
        q.offer(start)
        visited[start.y][start.x] = true
    }

    loop@ while (q.isNotEmpty()){
        val qSize = q.size
        day++

        for (i in 0 until qSize){
            val current = q.poll()

            for (j in 0 until 4){
                val r = current.y + direction[j][0]
                val c = current.x + direction[j][1]

                if (r in farm.indices && c in farm[0].indices && !visited[r][c] && farm[r][c] == 0){
                    count++
                    if (count == tCount) break@loop
                    visited[r][c] = true
                    q.offer(Point(c,r))
                }
            }
        }
    }
    answer = day
}
