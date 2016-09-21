[lu.jimenez.research.tools.utils](../index.md) / [MultiThreading](index.md) / [onFunctionWithSingleOutput](.)

# onFunctionWithSingleOutput

`fun <I, O> onFunctionWithSingleOutput(list: List<I>, function: (I) -> O, nbThread: Int): List<O>`

Method to launch a function on a list in a Multithreaded way

### Parameters

`list` - list of [I](#) to handle

`function` - a function that takes an element of [list](on-function-with-single-output.md#lu.jimenez.research.tools.utils.MultiThreading$onFunctionWithSingleOutput(kotlin.collections.List((lu.jimenez.research.tools.utils.MultiThreading.onFunctionWithSingleOutput.I)), kotlin.Function1((lu.jimenez.research.tools.utils.MultiThreading.onFunctionWithSingleOutput.I, lu.jimenez.research.tools.utils.MultiThreading.onFunctionWithSingleOutput.O)), kotlin.Int)/list) and return a result