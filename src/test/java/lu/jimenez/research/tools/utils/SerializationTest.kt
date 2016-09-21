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
import java.io.File
import java.io.Serializable

data class Document(val fullPath: String, val time: Int, val commitHash: String, val content: String) : Serializable

/**
 * Serialization object test class
 */
class SerializationTest : SubjectSpek<Serialization>({
    val path = javaClass.classLoader.getResource("").path
    subject { Serialization }
    val file = Document("file.c", 1230000, "ae80000", "content")
    given("a list of file") {
        val list = listOf(file, file, file)
        on("Saving") {
            subject.saveListData(list, path + "savingList.test")
            it("Should create a file") {
                assert(File(path + "savingList.test").exists())
            }
        }
        on("Loading") {
            val listofdata = subject.loadListData(path + "savingList.test") as List<Document>
            it("should return a list of size 3") {
                assert(listofdata.size == 3)
            }
        }
    }
    given("a map of file using the hash as a key") {
        val map = mutableMapOf<Int, Document>()
        map.put(file.hashCode(), file)
        on("Saving") {
            subject.saveMapHashData(map, path + "savingMapHash.test")
            assert(File(path + "savingMapHash.test").exists())
        }
        on("Loading") {
            val mapofdata = subject.loadMapHashData(path + "savingMapHash.test") as Map<Int, Document>
            it("should return a map of size 1") {
                assert(mapofdata.size == 1)
            }
        }
    }
    given("a map of file using a string as a key") {
        val map = mutableMapOf<String, Document>()
        map.put("test", file)
        on("Saving") {
            subject.saveMapStringData(map, path + "savingMapString.test")
            assert(File(path + "savingMapHash.test").exists())
        }
        on("Loading") {
            val mapofdata = subject.loadMapStringData(path + "savingMapString.test") as Map<String, Document>
            it("should return a map of size 1") {
                assert(mapofdata.size == 1)
            }
        }
    }
})
