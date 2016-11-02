package lu.jimenez.research.tools.utils


object NormalizingPathFolder {

    /**
     * Function normalizing a folder path, i.e., adding the missing / or \ depending on the os
     *
     * @param path path to normalize
     */
    fun normalizing(path: String): String {
        if (path.last().toString() != System.getProperty("file.separator"))
            return path + System.getProperty("file.separator")
        else
            return path
    }
}