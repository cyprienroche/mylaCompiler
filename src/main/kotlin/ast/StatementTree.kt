package ast

interface StatementTree

data class AssignmentTree(val variable: Variable, val expression: Expression) : StatementTree
