package frontend.errors

class ErrorListener<E> : EventListener<E> {
    private val es = mutableListOf<E>()

    val errors: List<E> = es

    val hasErrors: Boolean
        get() = es.isNotEmpty()

    override fun receive(event: E): Boolean = es.add(event)
}