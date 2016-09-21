[lu.jimenez.research.tools.utils.git](../index.md) / [GitUtilitary](index.md) / [listOfCommitImpactingAFile](.)

# listOfCommitImpactingAFile

`fun listOfCommitImpactingAFile(filePath: String, beforeThisCommit: String = "HEAD"): List<`[`NamedCommit`](-named-commit/index.md)`>?`

Function to retrieve the list of commit that impacted a given file before a given commit

### Parameters

`filePath` - file to study (path in the git repository)

`beforeThisCommit` - hash of the commit from which we should start (default HEAD)

### Exceptions

`NoSuchElementException` -

**Return**
list of commit that impacted the file (RevCommit)

