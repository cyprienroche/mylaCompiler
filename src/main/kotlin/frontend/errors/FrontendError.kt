package frontend.errors

class FrontendError(error: Error, pos: Pair<Int, Int>, msg: String) {
    val message: String = error.name + " Error at ${pos.first}:${pos.second} -- $msg"
}
