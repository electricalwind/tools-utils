
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