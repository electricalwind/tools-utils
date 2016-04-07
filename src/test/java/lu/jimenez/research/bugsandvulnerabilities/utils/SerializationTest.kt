package lu.jimenez.research.bugsandvulnerabilities.utils

import lu.jimenez.research.bugsandvulnerabilities.model.internal.Document
import org.jetbrains.spek.api.Spek
import org.junit.Assert.*
import java.io.File

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
            val map = mutableMapOf<Int,Document>()
            map.put(file.hashCode(),file)
            on("Saving"){
                Serialization.saveMapHashData(map,path + "savingMapHash.test")
                assert(File(path + "savingMapHash.test").exists())
            }
            on("Loading") {
                val mapofdata = Serialization.loadMapHashData(path + "savingMapHash.test") as Map<Int,Document>
                it("should return a map of size 1") {
                    assert(mapofdata.size == 1)
                }
            }
        }
        given("a map of file using a string as a key"){
            val map = mutableMapOf<String,Document>()
            map.put("test",file)
            on("Saving"){
                Serialization.saveMapStringData(map,path + "savingMapString.test")
                assert(File(path + "savingMapHash.test").exists())
            }
            on("Loading") {
                val mapofdata = Serialization.loadMapStringData(path + "savingMapString.test") as Map<String,Document>
                it("should return a map of size 1") {
                    assert(mapofdata.size == 1)
                }
            }
        }
    }
}