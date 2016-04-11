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

import java.io.File
import java.io.IOException
import java.util.regex.Pattern



/**
 * Object gathering method based on regexp or walking directory
 */
object RegexpAndWalk {

    /**
     * Method to extract url from a string
     *
     * @param text text to process
     *
     * @return list of extracted Url
     */
    fun extractUrls(text: String): List<String> {
        val containedUrls = mutableListOf<String>()
        val urlRegex = "((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)"
        val regex = Regex(urlRegex, RegexOption.IGNORE_CASE)
        val find = regex.findAll(text)

        for (findings in find) {
            containedUrls.add(findings.value)
        }
        return containedUrls
    }

    /**
     * Method to generate the list of File present in a directory and its subdirectory with the given extension
     *
     * @param folder repository to analyze
     * @param extension file extension (default = C files)
     *
     * @return List<String> list of the files
     */
    fun recursiveListOfFilesOfADirectory(folder: String, extension : String =".*\\.c$"): List<String> {
        val pattern = Pattern.compile(extension);
        try {
            return File(folder).walk().asSequence().filter { path -> path.isFile }.map { path -> path.toString()}
                    .map { path -> path.replace(folder,"") }
                    .filter { path -> pattern.matcher(path).find() }
                    .toMutableList()
        } catch (e: IOException) {
            e.printStackTrace()
            return mutableListOf()
        }
    }

    /**
     * Function to slice A string into a bag of words with their number of occurences
     *
     * @param file : File content (String)
     *
     * @return map of words and their frequency
     */
    fun slicingWord(file: String): Map<String, Int> {
        val listWord = file.split(Regex("\\W+"))
        return listWord.asSequence()
                .filter {word -> !word.equals("") && !word.contains("0x") }
                .filter {word -> !word.matches(Regex("[0-9]+")) && word.length > 1  }
                .fold(mutableMapOf<String,Int>(),{
                    map, item ->
                    if (!map.containsKey(item)) {
                        map.put(item, 1)
                    } else {
                        map.put(item, map[item]!! + 1)
                    }
                    map
                })
    }

    /**
     * Function to verify if a message contains a keywords
     *
     * @param message message to consider
     * @param listOfKeywords list of the keywords
     *
     * @return [Boolean]
     */
    fun containsAKeyword(message : String, listOfKeywords :List<String>):Boolean{
        listOfKeywords.forEach { key -> if(message.contains(key)) return true }
        return false
    }
}