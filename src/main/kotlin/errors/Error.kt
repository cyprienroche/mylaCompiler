package errors

enum class Error(val code: Int) {
    Syntax(100),
    Semantic(200),
}
