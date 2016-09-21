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

package lu.jimenez.research.tools.utils.diff

import difflib.Delta
import difflib.DiffUtils


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
        val patch = DiffUtils.diff(oldFile, newFile)
        val unifiedDiff = DiffUtils.generateUnifiedDiff(name + "_old", name + "_new",
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
    fun computeDelta(oldFile: String, newFile: String): DeltaHistory {
        val listoldFile = oldFile.split("\n")
        val listnewFile = newFile.split("\n")
        return computeDelta(listoldFile, listnewFile)
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
        val listDelta = DiffUtils.diff(oldFile, newFile).deltas
        var lineAdded = 0
        var lineModified = 0
        var lineDeleted = 0
        listDelta.forEach { delta ->
            when (delta.type) {
                Delta.TYPE.DELETE -> lineDeleted += delta.original.lines.size
                Delta.TYPE.CHANGE -> lineModified += delta.revised.lines.size
                Delta.TYPE.INSERT -> lineAdded += delta.revised.lines.size
                else -> error("wrong delta type")
            }
        }
        return DeltaHistory(lineAdded, lineDeleted, lineModified)
    }


}