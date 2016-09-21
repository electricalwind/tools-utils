[lu.jimenez.research.tools.utils](../index.md) / [MultiThreading](index.md) / [onFunctionWithListOutput](.)

# onFunctionWithListOutput

`fun <I, O> onFunctionWithListOutput(list: List<I>, function: (I) -> List<O>, nbThread: Int): List<O>`

Method to launch a function on a list in a Multithreaded way

### Parameters

`list` - list of [I](#) to handle

`function` - a function that takes an element of [list](on-function-with-list-output.md#lu.jimenez.research.tools.utils.MultiThreading$onFunctionWithListOutput(kotlin.collections.List((lu.jimenez.research.tools.utils.MultiThreading.onFunctionWithListOutput.I)), kotlin.Function1((lu.jimenez.research.tools.utils.MultiThreading.onFunctionWithListOutput.I, kotlin.collections.List((lu.jimenez.research.tools.utils.MultiThreading.onFunctionWithListOutput.O)))), kotlin.Int)/list) and return a result