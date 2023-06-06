import java.io.*

var count = 0

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val T = br.readLine().toInt()

    for (i in 1..T){
        val str = br.readLine()
        count = 0
        bw.write("${isPalindrome(str)} $count\n")
    }
    bw.flush()
    bw.close()
}

fun recursion (s : String, l : Int, r : Int) : Int{
    count++
    if (l >= r) { return 1 }
    else if(s[l] != s[r]) return 0
    else { return recursion(s,l+1,r-1) }
}

fun isPalindrome(s : String) : Int{
    return recursion(s,0,s.length-1)
}


