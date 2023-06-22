import java.util.*
import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val days = arrayOf("MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN")
    var calendar = Array(13) { Array(32) { "" } }
    var index = 0

    for (i in 1..12) {
        when (i) {
            1, 3, 5, 7, 8, 10, 12 -> {
                for (j in 1..31) {
                    calendar[i][j] = days[index]
                    if (index + 1 > 6) index = 0
                    else index++
                }
            }
            2 -> {
                for (j in 1..28){
                    calendar[i][j] = days[index]
                    if (index + 1 > 6) index = 0
                    else index++
                }
            }
            4,6,9,11 ->{
                for (j in 1..30){
                    calendar[i][j] = days[index]
                    if (index + 1 > 6) index = 0
                    else index++
                }
            }
        }
    }

    val token = StringTokenizer(readLine())

    val month = token.nextToken().toInt()
    val day = token.nextToken().toInt()

    bw.write(calendar[month][day])

    bw.flush()
    bw.close()
}

