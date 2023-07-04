import java.io.*
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var token = StringTokenizer(readLine())
    val k = token.nextToken().toInt()
    val n = token.nextToken().toInt()
    val lengthArr = IntArray(n)

    repeat(k){
        lengthArr[it] = readLine().toInt()
    }

    var minLength = 0L
    var maxLength = lengthArr.max().toLong() + 1L // 최대 길이보다 +1 값을 해야 답이 최대 길이일 때 구할 수 있다.

    // 이분 탐색
    while (minLength < maxLength){
        var count = 0L
        val midLength = (minLength + maxLength) / 2L

        for (i in lengthArr.indices){ // 랜선 자르기
            count += lengthArr[i] / midLength
        }

        if (count < n){ // 필요한 랜선 갯수보다 작으면 maxLength 값을 midLength 값으로 갱신
            maxLength = midLength
        }else{ // 필요한 랜선 갯수보다 크거나 같을 경우 minLength 값을 1씩 증가시켜서 최댓값 찾기
            minLength = midLength + 1
        }
    }

    bw.write("${minLength-1}")

    bw.flush()
    bw.close()
}
