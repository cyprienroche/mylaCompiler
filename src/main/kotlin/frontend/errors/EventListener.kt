package frontend.errors

@FunctionalInterface
interface EventListener<EventType> {
    fun receive(event: EventType): Boolean
}
