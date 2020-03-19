package visitor

import ast.ProgramTree
import generated.MylaParserBaseVisitor

class ProgramTreeVisitor : MylaParserBaseVisitor<ProgramTree>()
