[lu.jimenez.research.tools.utils.git](../index.md) / [GitUtilitary](index.md) / [gitBlame](.)

# gitBlame

`fun gitBlame(filePath: String, commitID: <ERROR CLASS>): List<<ERROR CLASS>>`

Function to retrieve the list of commit present in a git blame for a file in a given commit
the order of the list correspond to the order of line
e.g. :(element 1) -&gt; line 1 commit

### Parameters

`filePath` - file to study (path in the git repository)

`commitID` - hash of the commit (default HEAD)

### Exceptions

`NoSuchElementException` -

**Return**
list of the commit (RevCommit)

