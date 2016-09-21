[lu.jimenez.research.tools.utils.git](../index.md) / [GitUtilitary](index.md) / [previousCommitImpactingAFile](.)

# previousCommitImpactingAFile

`fun previousCommitImpactingAFile(filePath: String, beforeThisCommit: String = "HEAD"): `[`NamedCommit`](-named-commit/index.md)`?`

Function to retrieve the list of commit that impacted a given file before a given commit

### Parameters

`filePath` - file to study (path in the git repository)

`beforeThisCommit` - hash of the commit from which we should start (default HEAD)

### Exceptions

`NoSuchElementException` -

**Return**
list of commit that impacted the file (RevCommit)

