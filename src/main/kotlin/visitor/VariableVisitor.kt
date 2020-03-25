package visitor

import ast.assignments.VariableTree
import generated.MylaParserBaseVisitor

/* identifier */
class VariableVisitor : MylaParserBaseVisitor<VariableTree>()
