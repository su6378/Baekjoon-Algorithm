import java.util.*
import java.io.*
import kotlin.collections.ArrayList


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    val conference_room = ArrayList<Pair<Int, Int>>()

    for (i in 0 until n) {
        val token = StringTokenizer(br.readLine())
        val start = token.nextToken().toInt()
        val finish = token.nextToken().toInt()

        conference_room.add(Pair(start, finish))
    }

    conference_room.sortWith(compareBy { it.first })
    conference_room.sortWith(compareBy { it.second })


    var endTime = 0
    var count = 0
    for (i in 0 until conference_room.size) {
        if (conference_room[i].first >= endTime) {
            count++
            endTime = conference_room[i].second

        }

    }

    print(count)
}