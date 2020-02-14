import frontend.ParseTree

fun main() {
    val parseTree = ParseTree(path = "src/main/resources/Example.myla")
    println(parseTree.toString())
}
