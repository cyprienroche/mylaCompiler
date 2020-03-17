package frontend.errors

sealed class ProgramError(
    private val errorType: String,
    private val position: Pair<Int, Int>,
    private val message: String
) : Comparable<ProgramError> {
    override fun compareTo(other: ProgramError): Int = pairComparator.compare(this.position, other.position)
    override fun toString(): String = errorType + " Error at ${position.first}:${position.second} -- $message"
}

class SyntaxError(p: Pair<Int, Int>, m: String) : ProgramError("Syntax", p, m)

class SemanticError(p: Pair<Int, Int>, m: String) : ProgramError("Semantic", p, m)

private val pairComparator: Comparator<Pair<Int, Int>> = Comparator { p1, p2 ->
    when {
        p1.first != p2.first -> p1.first.compareTo(p2.first)
        else -> p1.second.compareTo(p2.second)
    }
}
