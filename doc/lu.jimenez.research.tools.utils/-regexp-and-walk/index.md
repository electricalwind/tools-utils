[lu.jimenez.research.tools.utils](../index.md) / [RegexpAndWalk](.)

# RegexpAndWalk

`object RegexpAndWalk`

Object gathering method based on regexp or walking directory

### Functions

| Name | Summary |
|---|---|
| [containsAKeyword](contains-a-keyword.md) | `fun containsAKeyword(message: String, listOfKeywords: List<String>): Boolean`<br>Function to verify if a message contains a keywords |
| [contentWithoutComment](content-without-comment.md) | `fun contentWithoutComment(content: String): String`<br>Function to remove all C style comment from a file |
| [extractUrls](extract-urls.md) | `fun extractUrls(text: String): List<String>`<br>Method to extract url from a string |
| [mapOfFrequency](map-of-frequency.md) | `fun mapOfFrequency(listOfKeywords: Iterable<String>): Map<String, Int>`<br>Function to put generate a map of Frequency from a list of String |
| [recursiveListOfFilesOfADirectory](recursive-list-of-files-of-a-directory.md) | `fun recursiveListOfFilesOfADirectory(folder: String, extension: String = ".*\\.c$"): List<String>`<br>Method to generate the list of File present in a directory and its subdirectory with the given extension |
| [slicingWord](slicing-word.md) | `fun slicingWord(file: String): Map<String, Int>`<br>Function to slice A string into a bag of words with their number of occurences |
| [slicingWordWithoutFilter](slicing-word-without-filter.md) | `fun slicingWordWithoutFilter(file: String): Map<String, Int>`<br>Function to slice A string into a bag of words with their number of occurences
without filtering the number and one letter word |
