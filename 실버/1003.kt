import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val t = readLine().toInt()

    val fibo = Array(41){IntArray(2)}

    fibo[0][0] = 1
    fibo[0][1] = 0
    fibo[1][0] = 0
    fibo[1][1] = 1

    for (i in 2 .. 40){
        fibo[i][0] = fibo[i-2][0] + fibo[i-1][0]
        fibo[i][1] = fibo[i-2][1] + fibo[i-1][1]
    }

    repeat(t){
        val n = readLine().toInt()
        bw.write("${fibo[n][0]} ${fibo[n][1]}\n")
    }


    bw.flush()
    bw.close()
}