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

import java.io.Serializable

/**
 * Delta History Data class
 *
 * Class representing the delta history of a file
 *
 * @property linesAdded number of lines that were added
 * @property linesDeleted number of lines that were deleted
 * @property linesModified number of lines that where modified
 *
 * @author Matthieu Jimenez
 */
data class DeltaHistory(var linesAdded: Int = 0, var linesDeleted: Int = 0, var linesModified: Int = 0) : Serializable {
    fun sum(delta: DeltaHistory) {
        this.linesAdded += delta.linesAdded
        this.linesDeleted += delta.linesDeleted
        this.linesModified += delta.linesModified
    }
}