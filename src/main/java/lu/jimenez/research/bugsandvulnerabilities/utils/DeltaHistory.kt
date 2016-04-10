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