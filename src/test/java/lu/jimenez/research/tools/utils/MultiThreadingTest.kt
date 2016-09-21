
package lu.jimenez.research.tools.utils

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.shouldBeTrue
import org.jetbrains.spek.api.shouldEqual

class MultiThreadingTest : Spek() {
    init {
        given("a list") {
            val list = listOf<Int>(4, 6, 8, 10, 12)
            on("applying multithreading with a function f returning an Int") {
                fun f(a: Int): Int {
                    return a + 2
                }

                val res = MultiThreading.onFunctionWithSingleOutput(list, { a -> f(a) }, 2)
                it("should return a list of size 5") {
                    shouldEqual(5, res.size)
                }
                it("containing 14") {
                    shouldBeTrue(res.contains(14))
                }
            }

        on("applying multithreading with a function f returning a list of Int") {
            fun f(a: Int): List<Int> {
                return listOf(a, a)
            }

            val res = MultiThreading.onFunctionWithListOutput(list, { a -> f(a) }, 2)
            it("should return a list of size 10") {
                shouldEqual(10, res.size)
            }
        }
    }
}
}