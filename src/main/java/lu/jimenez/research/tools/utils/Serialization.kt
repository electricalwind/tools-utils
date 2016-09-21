
package lu.jimenez.research.tools.utils

import java.io.*


/**
 * Serialization Utilitary object
 *
 * this object contains several functions that allow to serialize/ Deserialize a list of Serializable Object
 */
object Serialization {

    /**
     * Saving to an object file the array List of Serializable object
     *
     * @param listFile List to save
     * @param path pah of the file in which we will save
     */
    fun saveListData(listFile: List<Any>, path: String) {
        try {
            val fos = FileOutputStream(path)
            val oos = ObjectOutputStream(fos)
            oos.writeObject(listFile)
            oos.close()
            fos.close()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

    /**
     * Saving to an object file the map of objects
     *
     * @param mapHashObject map of object using its hash as a key
     * @param path pah of the file in which we will save
     */
    fun saveMapHashData(mapHashObject: Map<Int, Any>, path: String) {
        try {
            val fos = FileOutputStream(path)
            val oos = ObjectOutputStream(fos)
            oos.writeObject(mapHashObject)
            oos.close()
            fos.close()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

    /**
     * Saving to an object file a map of string object
     *
     * @param mapStringObject map of object using a string as a key
     * @param path pah of the file in which we will save
     */
    fun saveMapStringData(mapStringObject: Map<String, Any>, path: String) {
        try {
            val fos = FileOutputStream(path)
            val oos = ObjectOutputStream(fos)
            oos.writeObject(mapStringObject)
            oos.close()
            fos.close()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

    /**
     * Saving to an object file a map of string object
     *
     * @param mapStringObject map of object using a string as a key
     * @param path pah of the file in which we will save
     */
    fun saveMapData(mapStringObject: Map<Serializable, Serializable>, path: String) {
        try {
            val fos = FileOutputStream(path)
            val oos = ObjectOutputStream(fos)
            oos.writeObject(mapStringObject)
            oos.close()
            fos.close()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }


    /**
     * Loading the data save in an object file
     * Reverse of saveListData
     *
     * @param path path of the file
     * @return list of serialized objects
     */
    fun loadListData(path: String): List<Any>? {
        val fileIn = FileInputStream(path)
        val read = ObjectInputStream(fileIn)
        try {
            val listFile = read.readObject() as List<Any>
            read.close()
            fileIn.close()
            return listFile
        } catch(e: FileNotFoundException) {
            e.printStackTrace()
            return null
        }

    }

    /**
     * Loading the data save in an object file
     * Reverse of saveMapHashData
     *
     * @param path path of the file
     * @return map of object with their key as key
     */
    fun loadMapHashData(path: String): Map<Int, Any>? {
        val fileIn = FileInputStream(path)
        val read = ObjectInputStream(fileIn)
        try {
            val listFile = read.readObject() as Map<Int, Any>
            read.close()
            fileIn.close()
            return listFile
        } catch(e: FileNotFoundException) {
            e.printStackTrace()
            return null
        }

    }

    /**
     * Loading the data save in an object file
     * Reverse of saveMapStringData
     *
     * @param path path of the file
     * @return map of string object
     */
    fun loadMapStringData(path: String): Map<String, Any>? {
        val fileIn = FileInputStream(path)
        val read = ObjectInputStream(fileIn)
        try {
            val listFile = read.readObject() as Map<String, Any>
            read.close()
            fileIn.close()
            return listFile
        } catch(e: FileNotFoundException) {
            e.printStackTrace()
            return null
        }

    }
    /**
     * Loading the data save in an object file
     * Reverse of saveMapStringData
     *
     * @param path path of the file
     * @return map of string object
     */
    fun loadMapData(path: String): Map<Serializable, Serializable>? {
        val fileIn = FileInputStream(path)
        val read = ObjectInputStream(fileIn)
        try {
            val listFile = read.readObject() as Map<Serializable, Serializable>
            read.close()
            fileIn.close()
            return listFile
        } catch(e: FileNotFoundException) {
            e.printStackTrace()
            return null
        }

    }
}

 