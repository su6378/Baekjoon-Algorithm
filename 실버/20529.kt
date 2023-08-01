import java.io.*
import java.util.*
import kotlin.collections.HashMap
import kotlin.math.min

lateinit var dist: Array<IntArray>
lateinit var map: HashMap<String, Int>
var answer = 12

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val t = readLine().toInt()
    var st: StringTokenizer

    initMap()
    initDistance()

    repeat(t) {
        val n = readLine().toInt()
        val students = Array(n) { "" }
        answer = 12

        st = StringTokenizer(readLine())

        repeat(n) { i ->
            students[i] = st.nextToken()
        }

        combination(0, 0, students, Array(3) { "" })

        bw.write("$answer\n")
    }

    bw.flush()
    bw.close()
}

fun initMap() {
    map = HashMap()
    map["ISTJ"] = 0
    map["ISFJ"] = 1
    map["INFJ"] = 2
    map["INTJ"] = 3
    map["ISTP"] = 4
    map["ISFP"] = 5
    map["INFP"] = 6
    map["INTP"] = 7
    map["ESTP"] = 8
    map["ESFP"] = 9
    map["ENFP"] = 10
    map["ENTP"] = 11
    map["ESTJ"] = 12
    map["ESFJ"] = 13
    map["ENFJ"] = 14
    map["ENTJ"] = 15
}

fun initDistance() {
    dist = Array(16) { IntArray(16) }

    for (i in 0 until 16) {
        for (j in i until 16) {
            if (i == j) {
                dist[i][j] = 0
            } else {
                var cnt = 0
                val mbti = map.filterValues { it == i }.keys.first()
                val mbti2 = map.filterValues { it == j }.keys.first()
                for (k in mbti.indices) {
                    if (mbti[k] != mbti2[k]) cnt++
                }
                dist[i][j] = cnt
                dist[j][i] = cnt
            }
        }
    }
}

fun combination(size: Int, start: Int, students: Array<String>, selected: Array<String>) {
    if (answer == 0) return

    if (size == 3) {
        val a = map[selected[0]]!!
        val b = map[selected[1]]!!
        val c = map[selected[2]]!!
        answer = min(answer, dist[a][b] + dist[b][c] + dist[a][c])
        return
    }

    for (i in start until students.size) {
        selected[size] = students[i]
        combination(size + 1, i + 1, students, selected)
    }
}