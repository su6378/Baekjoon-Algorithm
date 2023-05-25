import java.util.*
import java.io.*
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val info = StringTokenizer(readLine())
    val N = info.nextToken().toInt()
    val M = info.nextToken().toInt()

    val treeArr = IntArray(N)

    val treeInfo = StringTokenizer(readLine())
    var maxHeight = -1

    repeat(N){ i ->
        treeArr[i] = treeInfo.nextToken().toInt()
        maxHeight = max(maxHeight,treeArr[i])
    }

    var minHeight = 0

    while (minHeight <= maxHeight){
        val mid = (minHeight + maxHeight) / 2
        var sum = 0L

        treeArr.forEach { tree ->
            if(tree - mid > 0) sum += (tree - mid).toLong() // 기준 높이보다 높으면 윗쪽 부분을 잘라서 sum에 추가
        }

        // M의 길이만큼 충족 못할 경우 높이 조정
        if (sum < M) maxHeight = mid - 1
        else minHeight = mid + 1
    }

    bw.write("$maxHeight")

    bw.flush()
    bw.close()
}

