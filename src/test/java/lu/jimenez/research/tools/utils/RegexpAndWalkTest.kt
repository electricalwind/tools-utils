
package lu.jimenez.research.tools.utils

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.shouldEqual


class RegexpAndWalkTest : Spek() {
    val path = javaClass.classLoader.getResource("").path

    init {
        //URL looking
        given("a text without any URL") {
            val textnourl = "this is a text without an url"
            on("analyzing it looking for URL") {
                val result = RegexpAndWalk.extractUrls(textnourl)
                it("should return an empty list") {
                    assert(result.size == 0)
                }
            }
        }
        given("a text with one URL") {
            val textwithurl = "this is a text with an url: http://www.jimenez.lu"
            on("analyzing it looking for URL") {
                val result = RegexpAndWalk.extractUrls(textwithurl)
                it("should return a list of size 1") {
                    assert(result.size == 1)
                }
                it("should return a string corresponding to the url") {
                    shouldEqual("http://www.jimenez.lu", result[0])
                }
            }
        }
        given("a text with two URL") {
            val textwithtwourl = "this is a text with two url: http://www.jimenez.lu and https://kotlinlang.org"
            on("analyzing it looking for URL") {
                val result = RegexpAndWalk.extractUrls(textwithtwourl)
                it("should return a list of size 2") {
                    assert(result.size == 2)
                }
                it("should have the second URL as the second element of the table") {
                    shouldEqual("https://kotlinlang.org", result[1])
                }
            }
        }


        //File walking
        given("a test folder") {
            val pathtest = path + "walkingTest/"
            on("retrievingn the recursive list of files") {
                val listOfFiles = RegexpAndWalk.recursiveListOfFilesOfADirectory(pathtest)
                it("should return a list of size 3") {
                    shouldEqual(3, listOfFiles.size)
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
            on("slicing words"){
                val slice= RegexpAndWalk.slicingWord(code)
                it("should return a map containing (val,4) "){
                    shouldEqual(4,slice["val"])
                }
            }
        }
    }

}