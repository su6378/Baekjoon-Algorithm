import java.io.*


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sik = br.readLine().toString().split("-")
    var min = sik[0].split("+").sumOf { it.toInt() }

    for (i in 1 until sik.size) {
        min -= sik[i].split("+").sumOf { it.toInt() }
    }

    println(min)
}