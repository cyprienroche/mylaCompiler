package visitor

import ast.Variable
import generated.MylaParserBaseVisitor

/* identifier */
class VariableVisitor : MylaParserBaseVisitor<Variable>()
