import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, k) = readLine().split(" ").map { it.toInt() }
    var i = 2
    var idx = 2
    var count = 0
    val primeArr = BooleanArray(n + 1)
    val deleteArr = BooleanArray(n + 1)

    while (i * i <= n) {
        if (!primeArr[i]) {
            var j = i * i

            while (j <= n) {
                primeArr[j] = true
                j += i
            }
        }
        i++
    }

    loop@ while (true) {
        var prime = idx
        while (true) {
            if (prime > n) break

            if (!deleteArr[prime]) { // 소수의 배수 지우기
                deleteArr[prime] = true
                count++
            }

            if (count == k) {
                bw.write("$prime")
                break@loop
            }

            prime += idx
        }

        while (true){
            if (!deleteArr[idx] && !primeArr[idx]) break
            idx++
        }
    }

    bw.flush()
    bw.close()
}