/////////////////////////////////////////////////////////////////////////////////////////
//                 University of Luxembourg  -
//                 Interdisciplinary center for Security and Trust (SnT)
//                 Copyright © 2016 University of Luxembourg, SnT
//
//
//  This library is free software; you can redistribute it and/or
//  modify it under the terms of the GNU Lesser General Public
//  License as published by the Free Software Foundation; either
//  version 3 of the License, or (at your option) any later version.
//
//  This library is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
//  Lesser General Public License for more details.
//
//  You should have received a copy of the GNU Lesser General Public
//  License along with this library; if not, write to the Free Software
//  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
//
//
//
//    Author: Matthieu Jimenez – SnT – matthieu.jimenez@uni.lu
//
//////////////////////////////////////////////////////////////////////////////////////////
package lu.jimenez.research.bugsandvulnerabilities.utils.diff

import lu.jimenez.research.bugsandvulnerabilities.utils.diff.DeltaHistory
import lu.jimenez.research.bugsandvulnerabilities.utils.diff.DiffComputing
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
