#Utils module

This maven module gather all utilitary methods that are used across all the different modules of the bugs and vulnerabilities project and that could be used in other context.

## Content

* Git utilitary + diff
* MultiThreading
* Regexp
* Serialization 


## Git
This module provide some useful function when trying to mine a git repository

###Use
     
     val git = GitUtilitary("pathto .git folder")
     git.retrievingFileFromSpecificCommit("hashOfCommit","fullpathOfFile")
     
### Class
    data class DeveloperHistory(val totalNumberOfDeveloper: Int = 0, val currentNumberOfDeveloper: Int = 0, val numberOfChanges: Int = 0) : Serializable

### Methods

* retrievingFileFromSpecificCommit
* listOfCommitImpactingAFile
* previousCommitImpactingAFile
* gitBlame
* gitBlameNbDev
* getDevHistoryOfAFile (use Developer History class)
* getDeltaFile (Delta History)
* getListOfModifiedFile
* getCommitMessage
* getTimeCommit

###Diff
This side module provides methods for computing unified diff or delta of between 2 versions of a file

##Multithreading
This object contains methods to launch a function on a list in a multithreaded way.
So far, 3 distinct version exist:

* one in case the function return a single element (onFunctionWithSingleOutput)
* one in case the function return a list of result that we need to flatten (onFunctionWithListOutput)
* one in case the function return a list of result that need to be gathered in a list of list. (onFunctionWithListListOutput)

        Multithreading.onFunctionWithListOutput(myList, { element -> function(element)},numberThread)
    
 This multithreading function relies on the JAVA Executors and CompletionService

##Regex
This object gather several methods based on regexp:

* extract url from a string
* recursive List Of Files Of A Directory with a given extension
* bag of Words
* removing C style comment
* find out if one keyword is present in a string
* map of frequency

## Serialization
This object contains method to load/save list or map of Serializable object

## Note

As other part of the project, this module is coded in Kotlin 1.0.0 and use Speck as a testing framework

Matthieu Jimenez - 2016