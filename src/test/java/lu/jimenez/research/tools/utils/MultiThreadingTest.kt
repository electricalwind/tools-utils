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

package lu.jimenez.research.tools.utils

import org.jetbrains.spek.api.SubjectSpek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class MultiThreadingTest : SubjectSpek<MultiThreading>({

    subject { MultiThreading }
    describe("a list") {
        val list = listOf<Int>(4, 6, 8, 10, 12)
        context("applying multithreading with a function f returning an Int") {
            fun f(a: Int): Int {
                return a + 2
            }

            val res = subject.onFunctionWithSingleOutput(list, { a -> f(a) }, 2)
            it("should return a list of size 5") {
                assert(5 == res.size)
            }
            it("containing 14") {
                assert(res.contains(14))
            }
        }

        context("applying multithreading with a function f returning a list of Int") {
            fun f(a: Int): List<Int> {
                return listOf(a, a)
            }

            val res = subject.onFunctionWithListOutput(list, { a -> f(a) }, 2)
            it("should return a list of size 10") {
                assert(10 == res.size)
            }
        }
    }

})
