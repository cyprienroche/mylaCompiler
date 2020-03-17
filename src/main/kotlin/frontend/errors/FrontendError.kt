package frontend.errors

class FrontendError(private val error: Error, private val pos: Pair<Int, Int>, private val message: String) :
    Comparable<FrontendError> {
    override fun compareTo(other: FrontendError): Int = pairComparator.compare(this.pos, other.pos)
    override fun toString(): String = error.name + " Error at ${pos.first}:${pos.second} -- $message"
}

private val pairComparator: Comparator<Pair<Int, Int>> = Comparator { p1, p2 ->
    when (p1.first) {
        p2.first -> p1.second.compareTo(p2.second)
        else -> p1.first.compareTo(p2.first)
    }
}
