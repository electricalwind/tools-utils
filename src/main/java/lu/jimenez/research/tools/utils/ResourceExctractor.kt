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
package lu.jimenez.research.tools.utils

import java.io.*
import java.net.HttpURLConnection
import java.net.URL
import java.security.Security
import java.util.zip.Adler32
import java.util.zip.CheckedInputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream


object ResourceExctractor {

    /**
     * function to download a file from the internet to a given path
     *
     * @param link of download
     * @param savingPath path of the folder in which the file should be save
     */
    fun downloadFromURL(link: String, savingPath: String) {
        if(link.split(":").first().last() =='s'){
            System.setProperty("java.protocol.handler.pkgs",
                    "com.sun.net.ssl.internal.www.protocol")
            Security.addProvider(com.sun.net.ssl.internal.ssl.Provider())
        }
        val filename = link.split("/").last()

        val url = URL(link)
        val connection = url.openConnection() as HttpURLConnection
        connection.requestMethod = "GET"
        val input = connection.inputStream
        val output = FileOutputStream(NormalizingPathFolder.normalizing(savingPath) + filename)
        copy(input, output, 1024)
        output.close()
    }

    private fun copy(input: InputStream, output: FileOutputStream, i: Int) {
        val but = ByteArray(i)
        var n = input.read(but)
        while (n >= 0) {
            output.write(but, 0, n)
            n = input.read(but)
        }
        output.flush()
    }

    /**
     * Function to unzip one or several file
     *
     * @param filePath path of the file to unzip
     * @param destDirectory directory in which the extracted file should be saved
     */
    fun unzipping(filePath: String, destDirectory: String): Long {
        val file = File(filePath)
        if (!file.exists())
            throw FileNotFoundException("file doesn't exist")
        if (filePath.split(".").last() != "zip") {
            throw FileNotFoundException("This is not a zip file")
        }
        val destsave = NormalizingPathFolder.normalizing(destDirectory)
        val fis = FileInputStream(filePath)
        val checksum = CheckedInputStream(fis, Adler32())
        val zis = ZipInputStream(BufferedInputStream(checksum))
        var entry: ZipEntry? = zis.nextEntry
        while (entry != null) {
            var count: Int
            val but = ByteArray(1024)
            val fos = FileOutputStream(destsave + entry.name)
            val dest = BufferedOutputStream(fos, 1024)
            count = zis.read(but, 0, 1024)
            while (count != -1) {
                dest.write(but, 0, count)
                count = zis.read(but, 0, 1024)
            }
            dest.flush()
            dest.close()
            entry = zis.nextEntry
        }

        val ch = checksum.checksum.value
        zis.close()
        return ch
    }

}