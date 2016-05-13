/////////////////////////////////////////////////////////////////////////////////////////
//                 University of Luxembourg  -
//                 Interdisciplinary center for Security and Trust (SnT)
//                 Copyright © 2016 University of Luxembourg, SnT
//
//
//  This library is free software; you can redistribute it and/or
//  modify it under the terms of the GNU Lesser General Public
//  License as published by the Free Software Foundation; either
//  version 3 of the License, or (at your option) any later version.
//
//  This library is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
//  Lesser General Public License for more details.
//
//  You should have received a copy of the GNU Lesser General Public
//  License along with this library; if not, write to the Free Software
//  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
//
//
//
//    Author: Matthieu Jimenez – SnT – matthieu.jimenez@uni.lu
//
//////////////////////////////////////////////////////////////////////////////////////////
package lu.jimenez.research.bugsandvulnerabilities.utils

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