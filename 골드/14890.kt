import java.io.*
import java.util.*
import kotlin.math.abs

var answer = 0
lateinit var st: StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, l) = readLine().split(" ").map { it.toInt() }
    val map = Array(n) { IntArray(n) }

    repeat(n) { i ->
        st = StringTokenizer(readLine())

        repeat(n) { j -> map[i][j] = st.nextToken().toInt() }
    }

    checkRow(n, l, map)
    checkCol(n, l, map)

    bw.write("$answer")

    bw.flush()
    bw.close()
}

fun checkRow(n: Int, l: Int, map: Array<IntArray>) {
    for (i in 0 until n) {
        var height = map[i][0]
        var isRoad = true
        val checked = BooleanArray(n)

        loop@ for (j in 1 until n) {
            if (map[i][j] == height) continue  // 높이가 같으면 pass

            // 높이가 1이상 차이날 경우
            if (abs(map[i][j] - height) > 1) {
                isRoad = false
                break@loop
            }

            // 현재 높이가 높을 경우
            if (map[i][j] > height) {
                // 경사로를 놓다가 범위를 벗어난 경우
                if (j - l < 0) {
                    isRoad = false
                    break@loop
                } else {
                    var sectionHeight = map[i][j - l]
                    for (k in j - l until j) {
                        if (k != j - l) { // 높이가 일정하지 않을 때
                            if (map[i][k] != sectionHeight) {
                                isRoad = false
                                break@loop
                            }
                        }

                        // 이미 경사로가 놓인 경우 break
                        if (checked[k]) {
                            isRoad = false
                            break@loop
                        }

                        sectionHeight = map[i][k]
                        checked[k] = true
                    }
                }
            } else if (map[i][j] < height) { // 현재 높이가 낮을 경우
                if (j - 1 + l >= n) {
                    isRoad = false
                    break@loop
                } else {
                    var sectionHeight = map[i][j]
                    for (k in j until j + l) {
                        if (k != j) {
                            if (map[i][k] != sectionHeight) {
                                isRoad = false
                                break@loop
                            }
                        }

                        sectionHeight = map[i][k]
                        checked[k] = true
                    }
                }
            }

            height = map[i][j]
        }

        if (isRoad) {
            answer++
        }
    }
}

fun checkCol(n: Int, l: Int, map: Array<IntArray>) {
    for (i in 0 until n) {
        var height = map[0][i]
        var isRoad = true
        val checked = BooleanArray(n)

        loop@ for (j in 1 until n) {
            if (map[j][i] == height) continue  // 높이가 같으면 pass

            // 높이가 1이상 차이날 경우
            if (abs(map[j][i] - height) > 1) {
                isRoad = false
                break@loop
            }

            // 현재 높이가 높을 경우
            if (map[j][i] > height) {
                // 경사로를 놓다가 범위를 벗어난 경우
                if (j - l < 0) {
                    isRoad = false
                    break@loop
                } else {
                    var sectionHeight = map[j - l][i]

                    for (k in j - l until j) {
                        if (k != j - l) {
                            if (map[k][i] != sectionHeight) {
                                isRoad = false
                                break@loop
                            }
                        }
                        if (checked[k]) { // 이미 경사로가 놓인 경우 break
                            isRoad = false
                            break@loop
                        }

                        sectionHeight = map[k][i]
                        checked[k] = true
                    }
                }
            } else if (map[j][i] < height) { // 현재 높이가 낮을 경우
                if (j - 1 + l >= n) {
                    isRoad = false
                    break@loop
                } else {
                    var sectionHeight = map[j][i]

                    for (k in j until j + l) {
                        if (k != j) {
                            if (map[k][i] != sectionHeight) {
                                isRoad = false
                                break@loop
                            }
                        }
                        sectionHeight = map[k][i]
                        checked[k] = true
                    }
                }
            }

            height = map[j][i]
        }

        if (isRoad) {
            answer++
        }
    }
}