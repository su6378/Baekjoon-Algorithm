import java.io.*
import java.util.*

lateinit var field : Array<IntArray>
lateinit var checked : Array<BooleanArray>
val dy = intArrayOf(-1, 1, 0, 0)
val dx = intArrayOf(0, 0, -1, 1)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val t = readLine().toInt()

    repeat(t){
        var token = StringTokenizer(readLine())
        val m = token.nextToken().toInt()
        val n = token.nextToken().toInt()
        val k = token.nextToken().toInt()
        var answer = 0

        field = Array(n){ IntArray(m) }
        checked = Array(n){ BooleanArray(m) }

        repeat(k){
            token = StringTokenizer(readLine())
            val x = token.nextToken().toInt()
            val y = token.nextToken().toInt()

            field[y][x] = 1
        }

        for (i in field.indices){
            for (j in field[i].indices){
                if (field[i][j] == 1 && !checked[i][j]) {
                    dfs(i,j)
                    answer++
                }
            }
        }

        bw.write("$answer\n")
    }

    bw.flush()
    bw.close()
}

fun dfs(row : Int, col : Int) {

    checked[row][col] = true

    for (i in 0 until 4){
        val nextR = row + dy[i]
        val nextC = col + dx[i]

        if (nextR in field.indices && nextC in field[0].indices){
            if (!checked[nextR][nextC] && field[nextR][nextC] == 1){
                checked[nextR][nextC] = true
                dfs(nextR,nextC)
            }
        }
    }
}