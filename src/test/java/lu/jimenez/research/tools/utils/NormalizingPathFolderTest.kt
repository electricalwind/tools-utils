package lu.jimenez.research.tools.utils

import org.jetbrains.spek.api.SubjectSpek
import org.jetbrains.spek.api.dsl.context
import org.jetbrains.spek.api.dsl.it


class NormalizingPathFolderTest : SubjectSpek<NormalizingPathFolder>({
    subject { NormalizingPathFolder }

    if (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0) { // Windows system
        context("for a correct URL path") {
            val path = "gg\\"
            it("should return the same string") {
                assert(path == subject.normalizing(path))
            }
        }
        context("for a missing \\ ") {
            val path = "gg"
            it("should return the same string + \\") {
                assert(path + "\\" == subject.normalizing(path))
            }
        }
    } else { //Unix system
        context("for a correct URL path") {
            val path = "gg/"
            it("should return the same string") {
                assert(path == subject.normalizing(path))
            }
        }
        context("for a missing / ") {
            val path = "gg"
            it("should return the same string + /") {
                assert(path + "/" == subject.normalizing(path))
            }
        }
    }
})