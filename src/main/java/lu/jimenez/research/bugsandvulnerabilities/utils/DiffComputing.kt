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



object DiffComputing {
    /**
     * Function to compute a unified diff
     *
     * @param oldFile : previous version of the file
     * @param newFile : new version of the file
     * @param name    : name of the file
     *
     * @return unified diff in string format
     */
    fun computeDiff(oldFile: String, newFile: String, name: String): String {
        val listoldFile = oldFile.split("\n")
        val listnewFile = newFile.split("\n")
        return computeDiff(listoldFile, listnewFile, name)
    }

    /**
     * Function to compute a unified diff
     *
     * @param oldFile : previous version of the file
     * @param newFile : new version of the file
     * @param name    : name of the file
     *
     * @return unified diff in string format
     */
    fun computeDiff(oldFile: List<String>, newFile: List<String>, name: String): String {
        val patch = difflib.DiffUtils.diff(oldFile, newFile)
        val unifiedDiff = difflib.DiffUtils.generateUnifiedDiff(name + "_old", name + "_new",
                oldFile, patch, 10)
        var diff = ""
        for (s in unifiedDiff) {
            diff = diff + s + "\n"
        }
        return diff
    }

    /**
     * Function to compute the delta
     *
     * @param oldFile : previous version of the file
     * @param newFile : new version of the file
     *
     * @return [DeltaHistory]
     */
    fun computeDelta(oldFile: String, newFile: String): DeltaHistory{
        val listoldFile = oldFile.split("\n")
        val listnewFile = newFile.split("\n")
        return computeDelta(listoldFile,listnewFile)
    }
    /**
     * Function to compute the delta
     *
     * @param oldFile : previous version of the file
     * @param newFile : new version of the file
     *
     * @return [DeltaHistory]
     */
    fun computeDelta(oldFile: List<String>, newFile: List<String>): DeltaHistory {
        val listDelta = difflib.DiffUtils.diff(oldFile, newFile).deltas
        var lineAdded = 0
        var lineModified = 0
        var lineDeleted = 0
        listDelta.forEach { delta ->
            when (delta.type) {
                difflib.Delta.TYPE.DELETE -> lineDeleted += delta.original.lines.size
                difflib.Delta.TYPE.CHANGE -> lineModified += delta.revised.lines.size
                difflib.Delta.TYPE.INSERT -> lineAdded += delta.revised.lines.size
                else -> error("wrong delta type")
            }
        }
        return DeltaHistory(lineAdded, lineDeleted, lineModified)
    }


}