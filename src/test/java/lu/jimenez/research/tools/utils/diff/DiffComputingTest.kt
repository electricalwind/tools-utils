
package lu.jimenez.research.tools.utils.diff

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.shouldBeTrue
import org.jetbrains.spek.api.shouldEqual

class DiffComputingTest : Spek() {
    init {
        given("a block of code in version 1 and version 2 ") {
            val codev1 =
                    """
import antlr.C.ModuleLexer
import ast.ASTNode
import ast.functionDef.FunctionDef
        """
            val codev2 =
                    """
import antlr.C.ModuleLexer
import ast.ASTNode
import ast.functionDef.FunctionDef
import lu.jimenez.research.filemetrics.ast.TestASTWalker
        """
            on("computing the diff") {
                val res = DiffComputing.computeDiff(codev1, codev2, "import")
                it("should return a unified diff"){
                    shouldBeTrue(res.contains("+import"))
                }
            }
            on("computing Delta"){
                val delta = DiffComputing.computeDelta(codev1,codev2)
                it("should return a delta of 1,0,0"){
                    shouldEqual(DeltaHistory(1),delta)
                }
            }
        }
    }
}
