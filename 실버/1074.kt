import java.io.*
import kotlin.math.pow

var answer = 0

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, r, c) = readLine().trim().split(" ").map { it.toInt() }

    val size = 2.0.pow(n.toDouble()).toInt()

    find(size,r,c)

    bw.write("$answer")

    bw.flush()
    bw.close()
}

fun find(size: Int, r: Int, c: Int) {
    if (size == 1) return

    if (r < size / 2 && c < size / 2) { // 1사분면
        find(size / 2, r, c)
    } else if (r < size / 2 && c >= size / 2) { // 2사분면
        answer += size * size / 4
        find(size / 2, r, c - size / 2)
    } else if (r >= size / 2 && c < size / 2) { // 3사분면
        answer += (size * size / 4) * 2
        find(size / 2, r - size / 2, c)
    } else { // 4사분면
        answer += (size * size / 4) * 3
        find(size / 2, r - size / 2, c - size / 2)
    }
}