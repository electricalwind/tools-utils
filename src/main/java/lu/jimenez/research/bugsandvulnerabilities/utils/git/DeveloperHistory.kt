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
package lu.jimenez.research.bugsandvulnerabilities.utils.git

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