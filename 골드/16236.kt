import java.awt.Point
import java.util.*
import java.io.*
import kotlin.collections.ArrayList

var fishes = Array(7) { ArrayList<Point>() }
lateinit var space: Array<IntArray>
var sharkWeight = 2
var eatCount = 0
val dy = intArrayOf(-1, 1, 0, 0)
val dx = intArrayOf(0, 0, -1, 1)
lateinit var visited : Array<BooleanArray>

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = readLine().toInt()

    space = Array(n) { IntArray(n) }
    var sharkLocation = Point()

    for (i in 0 until n) {
        val token = StringTokenizer(readLine())
        for (j in 0 until n) {
            space[i][j] = token.nextToken().toInt()
            when (space[i][j]) {
                1, 2, 3, 4, 5, 6 -> {
                    fishes[space[i][j]].add(Point(j, i))
                }

                9 -> {
                    sharkLocation = Point(j, i)
                    space[i][j] = 0
                }
            }
        }
    }

    var time = 0

    while (true) {
        var minD = Integer.MAX_VALUE // 최소 거리
        var target = Point() // 잡아 먹을 물고기 좌표
        var fishWeight = 0
        val fishMaxWeight = if (sharkWeight > 7) 7
        else sharkWeight

        if (!checkFish(fishMaxWeight)) break

        for (i in 1 until fishMaxWeight) {
            for (j in fishes[i].indices) {
                visited = Array(n) {BooleanArray(n)}
                val distance = bfs(sharkLocation, fishes[i][j]) // 해당 타겟까지의 이동 거리 수

                if (distance != Integer.MAX_VALUE){
                    if (minD > distance) { // 최소 거리를 찾으면
                        minD = distance
                        target = Point(fishes[i][j].x, fishes[i][j].y)
                        fishWeight = i
                    } else if (minD == distance) {
                        if (target.y > fishes[i][j].y) { // 위쪽에 있는 물고기로 갱신
                            target = Point(fishes[i][j].x, fishes[i][j].y)
                            fishWeight = i
                        } else if (target.y == fishes[i][j].y && target.x > fishes[i][j].x) { // 왼쪽에 있는 물고기로 갱신
                            target = Point(fishes[i][j].x, fishes[i][j].y)
                            fishWeight = i
                        }
                    }
                }
            }
        }

        if (minD == Integer.MAX_VALUE) break // 주변에 크기가 작은 물고기를 찾았지만 이동하지 못할 경우

        sharkLocation = Point(target.x, target.y) // 물고기를 잡아 먹은 상어 위치 갱신
        time += minD
        fishes[fishWeight].remove(target)
        space[target.y][target.x] = 0
        eatCount++

        if (eatCount == sharkWeight){ // 상어 자신의 크기만큼 물고기를 먹은 경우 크기 증가
            sharkWeight++
            eatCount = 0
        }

    }


    bw.write("$time")

    bw.flush()
    bw.close()
}

fun checkFish(fishMaxWeight : Int): Boolean {
    for (i in 1 until fishMaxWeight) {
        if (fishes[i].size > 0) return true
    }
    return false
}

fun bfs(sharkLocation: Point, target: Point): Int {
    val queue: Queue<Point> = LinkedList()
    var move = 0
    visited[sharkLocation.y][sharkLocation.x] = true
    queue.add(sharkLocation)

    while (queue.isNotEmpty()) {
        move++
        for (i in 0 until queue.size) {
            val point = queue.poll()
            for (i in 0 until 4) {
                val pointX = point.x + dx[i]
                val pointY = point.y + dy[i]

                if(pointY in space.indices && pointX in space.indices && space[pointY][pointX] <= sharkWeight  && !visited[pointY][pointX]){
                    if (pointY == target.y && pointX == target.x) return move
                    else {
                        queue.add(Point(pointX,pointY))
                        visited[pointY][pointX] = true
                    }
                }
            }
        }
    }
    return Integer.MAX_VALUE
}