import java.io.*
import java.util.*
import kotlin.collections.HashSet

lateinit var st: StringTokenizer
lateinit var parent: IntArray

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = readLine().split(" ").map { it.toInt() }
    val checked = BooleanArray(n + 1)
    val parties = Array(m + 1) { HashSet<Int>() }
    st = StringTokenizer(readLine())

    val r = st.nextToken().toInt()

    repeat(r) {
        val num = st.nextToken().toInt()

        checked[num] = true // 진실을 아는 사람 체크
    }

    parent = IntArray(n + 1)

    for (i in 1..n) {
        parent[i] = i
    }

    for (i in 1..m) {
        val info = readLine().split(" ")
        val p = info[0].toInt()

        if (p <= 1) { // 파티에 한 사람인 경우
            parties[i].add(info[1].toInt())
            continue
        }

        for (j in 1 until p) {
            val a = info[j].toInt()
            val b = info[j + 1].toInt()

            // 서로 다른 부모라면 합쳐주기
            if (find(a) != find(b)) union(a, b)

            // 파티에 참여하는 사람 저장
            parties[i].add(a)
            parties[i].add(b)

        }
    }

    val visited = BooleanArray(n + 1)

    for (i in 1..n) {
        if (checked[i] && !visited[i]) {
            val root = find(i)

            // 진실을 알고 있는 사람의 최상위 부모와 같을 경우 진실을 말하면 안된다
            for (j in 1..n){
                if (find(j) == root){
                    checked[j] = true
                    visited[j] = true
                }
            }
        }
    }

    var answer = 0

    for (i in 1..m){
        var flag = true

        for (person in parties[i]){
            if (checked[person]){ // 진실을 말하면 안되는 멤버가 있는 경우
                flag = false
                break
            }
        }

        if (flag) answer++
    }

    bw.write("$answer")

    bw.flush()
    bw.close()
}

fun find(idx: Int): Int {
    if (parent[idx] == idx) return idx

    parent[idx] = find(parent[idx])
    return parent[idx]
}

fun union(a: Int, b: Int) {
    val parentB = find(b)
    parent[parentB] = a
}