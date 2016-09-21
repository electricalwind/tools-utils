package lu.jimenez.research.tools.utils

import org.jetbrains.spek.api.Spek
import java.io.File
import java.io.Serializable

data class Document(val fullPath: String, val time: Int, val commitHash: String, val content: String) : Serializable

/**
 * Serialization object test class
 */
class SerializationTest : Spek() {
    val path = javaClass.classLoader.getResource("").path

    init {
        val file = Document("file.c", 1230000, "ae80000", "content")
        given("a list of file") {
            val list = listOf(file, file, file)
            on("Saving") {
                Serialization.saveListData(list, path + "savingList.test")
                it("Should create a file") {
                    assert(File(path + "savingList.test").exists())
                }
            }
            on("Loading") {
                val listofdata = Serialization.loadListData(path + "savingList.test") as List<Document>
                it("should return a list of size 3") {
                    assert(listofdata.size == 3)
                }
            }
        }
        given("a map of file using the hash as a key"){
            val map = mutableMapOf<Int, Document>()
            map.put(file.hashCode(),file)
            on("Saving"){
                Serialization.saveMapHashData(map,path + "savingMapHash.test")
                assert(File(path + "savingMapHash.test").exists())
            }
            on("Loading") {
                val mapofdata = Serialization.loadMapHashData(path + "savingMapHash.test") as Map<Int, Document>
                it("should return a map of size 1") {
                    assert(mapofdata.size == 1)
                }
            }
        }
        given("a map of file using a string as a key"){
            val map = mutableMapOf<String, Document>()
            map.put("test",file)
            on("Saving"){
                Serialization.saveMapStringData(map,path + "savingMapString.test")
                assert(File(path + "savingMapHash.test").exists())
            }
            on("Loading") {
                val mapofdata = Serialization.loadMapStringData(path + "savingMapString.test") as Map<String, Document>
                it("should return a map of size 1") {
                    assert(mapofdata.size == 1)
                }
            }
        }
    }
}