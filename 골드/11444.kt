import java.io.*

const val MOD = 1000000007L

/*
*                            n
*       | 1   1 |    | F(n+1)  F(n)  |
* A^n = |       |  = |               |
*       | 1   0 |    |  F(n)  F(n-1) |
 */
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = readLine().toLong()

    bw.write("${fibo(n-1)[0][0]}")

    bw.flush()
    bw.close()
}

fun fibo(n: Long): Array<LongArray> {
    if (n == 1L || n == 0L) return arrayOf(longArrayOf(1, 1), longArrayOf(1, 0))

    val arr = fibo(n / 2)

    // 만약 지수가 홀수라면 마지막에  A^1 (origin)을 곱해준다.
    return if (n % 2 == 1L) multi(multi(arr, arr), fibo(1))
    else multi(arr, arr)
}

fun multi(a: Array<LongArray>, b: Array<LongArray>): Array<LongArray> {
    val arr = Array(2) { LongArray(2) }

    arr[0][0] = (a[0][0] * b[0][0] % MOD + a[0][1] * b[1][0] % MOD) % MOD
    arr[1][0] = (a[0][0] * b[0][1] % MOD + a[0][1] * b[1][1] % MOD) % MOD
    arr[0][1] = (a[1][0] * b[0][0] % MOD + a[1][1] * b[1][0] % MOD) % MOD
    arr[1][1] = (a[1][0] * b[0][1] % MOD + a[1][1] * b[1][1] % MOD) % MOD
    return arr
}