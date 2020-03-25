package ast

import ast.assignments.ExpressionTree
import ast.assignments.VariableTree

data class AssignmentTree(val variable: VariableTree, val expression: ExpressionTree) :
    StatementTree
