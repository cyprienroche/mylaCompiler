package visitor

import ast.Variable
import generated.MylaParserBaseVisitor

class VariableVisitor : MylaParserBaseVisitor<Variable>()
