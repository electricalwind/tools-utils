/*-
 * #%L
 * Utilitary
 * %%
 * Copyright (C) 2016 Matthieu Jimenez
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package lu.jimenez.research.tools.utils.diff

import org.jetbrains.spek.api.SubjectSpek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class DiffComputingTest : SubjectSpek<DiffComputing>({

    subject { DiffComputing }

    describe("a block of code in version 1 and version 2 ") {
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
        context("computing the diff") {
            val res = subject.computeDiff(codev1, codev2, "import")
            it("should return a unified diff") {
                assert(res.contains("+import"))
            }
        }
        context("computing Delta") {
            val delta = subject.computeDelta(codev1, codev2)
            it("should return a delta of 1,0,0") {
                assert(DeltaHistory(1) == delta)
            }
        }
    }
})

