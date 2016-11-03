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