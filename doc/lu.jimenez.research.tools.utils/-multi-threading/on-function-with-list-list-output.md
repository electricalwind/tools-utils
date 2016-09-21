[lu.jimenez.research.tools.utils](../index.md) / [MultiThreading](index.md) / [onFunctionWithListListOutput](.)

# onFunctionWithListListOutput

`fun <I, O> onFunctionWithListListOutput(list: List<I>, function: (I) -> List<O>, nbThread: Int): List<List<O>>`

Method to launch a function on a list in a Multithreaded way

### Parameters

`list` - list of [I](#) to handle

`function` - a function that takes an element of [list](on-function-with-list-list-output.md#lu.jimenez.research.tools.utils.MultiThreading$onFunctionWithListListOutput(kotlin.collections.List((lu.jimenez.research.tools.utils.MultiThreading.onFunctionWithListListOutput.I)), kotlin.Function1((lu.jimenez.research.tools.utils.MultiThreading.onFunctionWithListListOutput.I, kotlin.collections.List((lu.jimenez.research.tools.utils.MultiThreading.onFunctionWithListListOutput.O)))), kotlin.Int)/list) and return a result