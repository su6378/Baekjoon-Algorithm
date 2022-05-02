import java.util.*
import java.io.*


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    val railArr = LongArray(n-1)
    val railTk = StringTokenizer(br.readLine())

    for(i in 0 until n-1){
      val rail = railTk.nextToken().toLong()
        railArr[i] = rail
    }

    val fuelArr = LongArray(n)
    val fuelTk = StringTokenizer(br.readLine())

    for(i in 0 until n){
      val fuel = fuelTk.nextToken().toLong()
        fuelArr[i] = fuel
    }

    var min = fuelArr[0]
    var total = 0L
    for(i in 0 until n-1){
        if(min > fuelArr[i]){
            min = fuelArr[i]
        }
        total += min * railArr[i]
    }

    println(total)
}