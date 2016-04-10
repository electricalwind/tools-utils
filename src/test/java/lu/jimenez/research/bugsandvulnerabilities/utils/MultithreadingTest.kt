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
package lu.jimenez.research.bugsandvulnerabilities.utils

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