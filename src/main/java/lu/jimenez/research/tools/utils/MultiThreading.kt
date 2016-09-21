/*-
 * #%L
 * Utilitary
 * %%
 * Copyright (C) 2016 Matthieu Jimenez
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

package lu.jimenez.research.tools.utils

import java.util.*
import java.util.concurrent.CompletionService
import java.util.concurrent.ExecutionException
import java.util.concurrent.ExecutorCompletionService
import java.util.concurrent.Executors

/**
 * Object gathering methods for launching a function in a multithreaded way
 */
object MultiThreading {

    /**
     * Method to launch a function on a list in a Multithreaded way
     *
     * @param list list of [I] to handle
     * @param function a function that takes an element of [list] and return a result
     *
     * @property I Input
     * @property O Output
     *
     * @return a list of [O] element
     */
    fun <I, O> onFunctionWithSingleOutput(list: List<I>, function: (I) -> O, nbThread: Int): List<O> {
        val resultList = ArrayList<O>()
        var errornb = 0
        val executor = Executors.newFixedThreadPool(nbThread)
        //Declaring Executors
        try {
            //Sending
            val completionService: CompletionService<O> = ExecutorCompletionService(executor)
            var count = 0
            for (item in list) {
                completionService.submit({ function(item) })
                count++
            }
            //Receiving
            var received = 0

            while (received < count) {
                val fut = completionService.take()
                try {
                    val result = fut.get()
                    //received++
                    if (result != null)
                        resultList.add(result)
                } catch (e: ExecutionException) {
                    e.printStackTrace()
                    errornb++
                } finally {
                    received++
                    //println("$received / $count")
                }
            }
        } catch (e: InterruptedException) {
            e.printStackTrace()
        } finally {
            println("error : $errornb")
            executor.shutdown()
            return resultList
        }
    }

    /**
     * Method to launch a function on a list in a Multithreaded way
     *
     * @param list list of [I] to handle
     * @param function a function that takes an element of [list] and return a result
     *
     * @property I Input
     * @property O Output
     *
     * @return a list of [O] element
     */
    fun <I, O> onFunctionWithListOutput(list: List<I>, function: (I) -> List<O>, nbThread: Int): List<O> {
        val resultList = ArrayList<O>()
        val executor = Executors.newFixedThreadPool(nbThread)
        try {
            //Declaring Executors
            val completionService: CompletionService<List<O>> = ExecutorCompletionService(executor)

            //Sending
            var count = 0
            for (item in list) {
                completionService.submit({ function(item) })
                count++
            }

            //Receiving
            var received = 0
            while (received < count) {
                val fut = completionService.take()
                try {
                    val result = fut.get()
                    received++
                    if (result != null)
                        resultList.addAll(result)
                } catch (e: ExecutionException) {
                    e.printStackTrace()
                }
            }
        } catch (e: InterruptedException) {
            e.printStackTrace()
        } finally {
            executor.shutdown()
            return resultList
        }
    }


    /**
     * Method to launch a function on a list in a Multithreaded way
     *
     * @param list list of [I] to handle
     * @param function a function that takes an element of [list] and return a result
     *
     * @property I Input
     * @property O Output
     *
     * @return a list of [O] element
     */
    fun <I, O> onFunctionWithListListOutput(list: List<I>, function: (I) -> List<O>, nbThread: Int): List<List<O>> {
        val resultList = ArrayList<List<O>>()
        val executor = Executors.newFixedThreadPool(nbThread)
        try {
            //Declaring Executors
            val completionService: CompletionService<List<O>> = ExecutorCompletionService(executor)

            //Sending
            var count = 0
            for (item in list) {
                completionService.submit({ function(item) })
                count++
            }

            //Receiving
            var received = 0
            while (received < count) {
                val fut = completionService.take()
                try {
                    val result = fut.get()
                    received++
                    if (result != null)
                        resultList.add(result)
                } catch (e: ExecutionException) {
                    e.printStackTrace()
                }
            }
        } catch (e: InterruptedException) {
            e.printStackTrace()
        } finally {
            executor.shutdown()
            return resultList
        }
    }
}