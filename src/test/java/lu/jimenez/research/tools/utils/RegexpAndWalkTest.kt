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
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on


class RegexpAndWalkTest : SubjectSpek<RegexpAndWalk>({
    val path = javaClass.classLoader.getResource("").path
    subject { RegexpAndWalk }
    //URL looking
    given("a text without any URL") {
        val textnourl = "this is a text without an url"
        on("analyzing it looking for URL") {
            val result = subject.extractUrls(textnourl)
            it("should return an empty list") {
                assert(result.size == 0)
            }
        }
    }
    given("a text with one URL") {
        val textwithurl = "this is a text with an url: http://www.jimenez.lu"
        on("analyzing it looking for URL") {
            val result = subject.extractUrls(textwithurl)
            it("should return a list of size 1") {
                assert(result.size == 1)
            }
            it("should return a string corresponding to the url") {
                assert("http://www.jimenez.lu" == result[0])
            }
        }
    }
    given("a text with two URL") {
        val textwithtwourl = "this is a text with two url: http://www.jimenez.lu and https://kotlinlang.org"
        on("analyzing it looking for URL") {
            val result = subject.extractUrls(textwithtwourl)
            it("should return a list of size 2") {
                assert(result.size == 2)
            }
            it("should have the second URL as the second element of the table") {
                assert("https://kotlinlang.org" == result[1])
            }
        }
    }


    //File walking
    given("a test folder") {
        val pathtest = path + "walkingTest/"
        on("retrievingn the recursive list of files") {
            val listOfFiles = subject.recursiveListOfFilesOfADirectory(pathtest)
            it("should return a list of size 3") {
                assert(3 == listOfFiles.size)
            }
        }

    }

    //Slicing
    given("a block of code") {
        val code = """val NB_THREAD = 8
            val SOFTWARE = "linux_kernel"
            //CVE XML
            val YEAR_BEGINNING = 2002
            val YEAR_END = 2016"""
        on("slicing words") {
            val slice = RegexpAndWalk.slicingWord(code)
            it("should return a map containing (val,4) ") {
                assert(4 == slice["val"])
            }
        }
    }
})

