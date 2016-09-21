[lu.jimenez.research.tools.utils.diff](../index.md) / [DeltaHistory](.)

# DeltaHistory

`data class DeltaHistory : `[`Serializable`](http://docs.oracle.com/javase/6/docs/api/java/io/Serializable.html)

Delta History Data class

Class representing the delta history of a file

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `DeltaHistory(linesAdded: Int = 0, linesDeleted: Int = 0, linesModified: Int = 0)`<br>Delta History Data class |

### Properties

| Name | Summary |
|---|---|
| [linesAdded](lines-added.md) | `var linesAdded: Int`<br>number of lines that were added |
| [linesDeleted](lines-deleted.md) | `var linesDeleted: Int`<br>number of lines that were deleted |
| [linesModified](lines-modified.md) | `var linesModified: Int`<br>number of lines that where modified |

### Functions

| Name | Summary |
|---|---|
| [sum](sum.md) | `fun sum(delta: DeltaHistory): Unit` |
