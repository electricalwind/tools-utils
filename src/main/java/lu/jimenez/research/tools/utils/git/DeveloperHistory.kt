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

package lu.jimenez.research.tools.utils.git

import java.io.Serializable

/**
 * Developer History Data Class
 *
 * This class correspond to the developper history
 *
 * @property numberOfChanges number of change that has been made to the file to this date
 * @property totalNumberOfDeveloper number of Developer that have worked on this file
 * @property currentNumberOfDeveloper number of Developer that have worked on the current version of this file (git blame)
 *
 * @author Matthieu Jimenez
 */
data class DeveloperHistory(val totalNumberOfDeveloper: Int = 0, val currentNumberOfDeveloper: Int = 0, val numberOfChanges: Int = 0) : Serializable