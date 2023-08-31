import java.io.*
import java.util.*

const val DEGREE = 90
lateinit var st: StringTokenizer
lateinit var notebook: Array<IntArray>
lateinit var rotateSticker: Array<IntArray>
var answer = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m, k) = readLine().split(" ").map { it.toInt() }
    notebook = Array(n) { IntArray(m) }

    repeat(k) {
        st = StringTokenizer(readLine())
        val r = st.nextToken().toInt()
        val c = st.nextToken().toInt()

        val sticker = Array(r) { IntArray(c) }

        for (i in 0 until r) {
            st = StringTokenizer(readLine())

            for (j in 0 until c) {
                sticker[i][j] = st.nextToken().toInt()
            }
        }

        for (i in 0 until 4) {
            rotate(sticker, r, c, DEGREE * i)
            if (stick()) break
        }
    }

    bw.write("$answer")

    bw.flush()
    bw.close()
}

fun rotate(sticker: Array<IntArray>, r: Int, c: Int, degree: Int) {
    when (degree) {
        0, 180 -> rotateSticker = Array(r) { IntArray(c) }
        90, 270 -> rotateSticker = Array(c) { IntArray(r) }
    }

    for (i in rotateSticker.indices) {
        for (j in rotateSticker[0].indices) {
            when (degree) {
                0 -> rotateSticker[i][j] = sticker[i][j]
                90 -> rotateSticker[i][j] = sticker[r - 1 - j][i]
                180 -> rotateSticker[i][j] = sticker[r - 1 - i][c - 1 - j]
                270 -> rotateSticker[i][j] = sticker[j][c - 1 - i]
            }
        }
    }
}

fun stick(): Boolean {
    for (i in notebook.indices) {
        for (j in notebook[0].indices) {
            if (search(j, i)) return true
        }
    }
    return false
}

fun search(x: Int, y: Int): Boolean {
    val n = notebook.size
    val m = notebook[0].size
    val r = rotateSticker.size
    val c = rotateSticker[0].size

    if (x + c > m || y + r > n) return false

    for (i in 0 until r) {
        for (j in 0 until c) {
            if (rotateSticker[i][j] == 1 && notebook[i + y][j + x] == 1) return false
        }
    }

    for (i in 0 until r) {
        for (j in 0 until c) {
            if (rotateSticker[i][j] == 1) {
                notebook[i + y][j + x] = 1
                answer++
            }
        }
    }
    return true
}