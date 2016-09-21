[lu.jimenez.research.tools.utils.git](../index.md) / [DeveloperHistory](.)

# DeveloperHistory

`data class DeveloperHistory : `[`Serializable`](http://docs.oracle.com/javase/6/docs/api/java/io/Serializable.html)

Developer History Data Class

This class correspond to the developper history

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `DeveloperHistory(totalNumberOfDeveloper: Int = 0, currentNumberOfDeveloper: Int = 0, numberOfChanges: Int = 0)`<br>Developer History Data Class |

### Properties

| Name | Summary |
|---|---|
| [currentNumberOfDeveloper](current-number-of-developer.md) | `val currentNumberOfDeveloper: Int`<br>number of Developer that have worked on the current version of this file (git blame) |
| [numberOfChanges](number-of-changes.md) | `val numberOfChanges: Int`<br>number of change that has been made to the file to this date |
| [totalNumberOfDeveloper](total-number-of-developer.md) | `val totalNumberOfDeveloper: Int`<br>number of Developer that have worked on this file |
