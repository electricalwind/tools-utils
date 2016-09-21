[lu.jimenez.research.tools.utils.git](../index.md) / [GitUtilitary](.)

# GitUtilitary

`class GitUtilitary`

Git Utilitary class

This class contains some useful Method some are just adaption from [jgit Cookbook](https//github.com/centic9/jgit-cookbook)

### Types

| Name | Summary |
|---|---|
| [NamedCommit](-named-commit/index.md) | `data class NamedCommit` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `GitUtilitary(pathToRepo: String)`<br>Git Utilitary class |

### Properties

| Name | Summary |
|---|---|
| [git](git.md) | `val git: <ERROR CLASS>` |
| [pathToRepo](path-to-repo.md) | `val pathToRepo: String`<br>path to the git repository to study |
| [repo](repo.md) | `val repo: <ERROR CLASS>` |

### Functions

| Name | Summary |
|---|---|
| [close](close.md) | `fun close(): Unit`<br>Method to be called when work on git has been done |
| [getCommitMessage](get-commit-message.md) | `fun getCommitMessage(hash: String): String`<br>Method to retireve the message of a given commit |
| [getDeltaFile](get-delta-file.md) | `fun getDeltaFile(filePath: String, commit: String = "HEAD"): `[`DeltaHistory`](../../lu.jimenez.research.tools.utils.diff/-delta-history/index.md)`?`<br>Function to get the Delta history of a file before a given commit |
| [getDeltaFileFromList](get-delta-file-from-list.md) | `fun getDeltaFileFromList(listofCommit: List<`[`NamedCommit`](-named-commit/index.md)`>): `[`DeltaHistory`](../../lu.jimenez.research.tools.utils.diff/-delta-history/index.md)<br>Function to get the Delta history of a file through a given list of commit |
| [getDevHistoryOfAFile](get-dev-history-of-a-file.md) | `fun getDevHistoryOfAFile(filePath: String, commit: String = "HEAD"): `[`DeveloperHistory`](../-developer-history/index.md)`?`<br>Function to get the Developer History of a File before a given commit |
| [getDevHistoryOfAFileFromList](get-dev-history-of-a-file-from-list.md) | `fun getDevHistoryOfAFileFromList(listofCommit: List<`[`NamedCommit`](-named-commit/index.md)`> = ArrayList()): `[`DeveloperHistory`](../-developer-history/index.md)<br>Function to get the Developer History of a File before a given commit and for
given list of commit |
| [getListOfModifiedFile](get-list-of-modified-file.md) | `fun getListOfModifiedFile(hash: String, pattern: String? = null): List<String>`<br>Method to get the list of all file corresponding to a given pattern modified by a specific commit |
| [getRenamedPath](get-renamed-path.md) | `fun getRenamedPath(start: <ERROR CLASS>, path: String?): String?`<br>Function to retrieve the rename of file in previous commit
This function has a timeout of 10s to avoid blocking for too long in large git repository |
| [getTimeCommit](get-time-commit.md) | `fun getTimeCommit(hash: String): Int`<br>Method to retrieve the time of a commit |
| [gitBlame](git-blame.md) | `fun gitBlame(filePath: String, commitID: <ERROR CLASS>): List<<ERROR CLASS>>`<br>Function to retrieve the list of commit present in a git blame for a file in a given commit
the order of the list correspond to the order of line
e.g. :(element 1) -&gt; line 1 commit |
| [gitBlameNbDev](git-blame-nb-dev.md) | `fun gitBlameNbDev(filePath: String, commit: <ERROR CLASS>): Int`<br>Function to get the Number of Developer present on a git blame result |
| [listOfCommitImpactingAFile](list-of-commit-impacting-a-file.md) | `fun listOfCommitImpactingAFile(filePath: String, beforeThisCommit: String = "HEAD"): List<`[`NamedCommit`](-named-commit/index.md)`>?`<br>Function to retrieve the list of commit that impacted a given file before a given commit |
| [previousCommitImpactingAFile](previous-commit-impacting-a-file.md) | `fun previousCommitImpactingAFile(filePath: String, beforeThisCommit: String = "HEAD"): `[`NamedCommit`](-named-commit/index.md)`?`<br>Function to retrieve the list of commit that impacted a given file before a given commit |
| [retrievingFileFromSpecificCommit](retrieving-file-from-specific-commit.md) | `fun retrievingFileFromSpecificCommit(commit: String, path: String): String?`<br>Function to retrieve a file from a specific commit |
