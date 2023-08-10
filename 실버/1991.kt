import java.io.*
import java.util.*

data class Node(val data: String, var left: Node? = null, var right: Node? = null)

class Tree {
    var root: Node? = null

    fun add(data: String, lData: String, rData: String) {
        if (root == null) { // 루트 노드가 없으면 추가
            if (data != ".") root = Node(data)
            if (lData != ".") root!!.left = Node(lData)
            if (rData != ".") root!!.right = Node(rData)
        } else search(root!!, data, lData, rData) // 탐색
    }

    private fun search(root: Node, data: String, lData: String, rData: String) {
        if (root.data == data) { // 찾으면 왼쪽 자식과 오른쪽 자식 갱신
            if (lData != ".") root.left = Node(lData)
            if (rData != ".") root.right = Node(rData)
        } else {
            if (root.left != null) search(root.left!!, data, lData, rData)
            if (root.right != null) search(root.right!!, data, lData, rData)
        }
    }

    fun preOrder(root: Node) {
        bw.write(root.data)
        if (root.left != null) preOrder(root.left!!)
        if (root.right != null) preOrder(root.right!!)
    }

    fun inOrder(root: Node) {
        if (root.left != null) inOrder(root.left!!)
        bw.write(root.data)
        if (root.right != null) inOrder(root.right!!)
    }

    fun postOrder(root: Node) {
        if (root.left != null) postOrder(root.left!!)
        if (root.right != null) postOrder(root.right!!)
        bw.write(root.data)
    }
}

lateinit var st: StringTokenizer
lateinit var bw: BufferedWriter

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = readLine().toInt()
    val tree = Tree()

    repeat(n) {
        st = StringTokenizer(readLine())
        val root = st.nextToken()
        val left = st.nextToken()
        val right = st.nextToken()

        tree.add(root, left, right)
    }

    tree.preOrder(tree.root!!)
    bw.write("\n")

    tree.inOrder(tree.root!!)
    bw.write("\n")

    tree.postOrder(tree.root!!)

    bw.flush()
    bw.close()
}