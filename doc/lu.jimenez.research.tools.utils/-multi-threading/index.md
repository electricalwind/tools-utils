[lu.jimenez.research.tools.utils](../index.md) / [MultiThreading](.)

# MultiThreading

`object MultiThreading`

Object gathering methods for launching a function in a multithreaded way

### Functions

| Name | Summary |
|---|---|
| [onFunctionWithListListOutput](on-function-with-list-list-output.md) | `fun <I, O> onFunctionWithListListOutput(list: List<I>, function: (I) -> List<O>, nbThread: Int): List<List<O>>`<br>Method to launch a function on a list in a Multithreaded way |
| [onFunctionWithListOutput](on-function-with-list-output.md) | `fun <I, O> onFunctionWithListOutput(list: List<I>, function: (I) -> List<O>, nbThread: Int): List<O>`<br>Method to launch a function on a list in a Multithreaded way |
| [onFunctionWithSingleOutput](on-function-with-single-output.md) | `fun <I, O> onFunctionWithSingleOutput(list: List<I>, function: (I) -> O, nbThread: Int): List<O>`<br>Method to launch a function on a list in a Multithreaded way |
