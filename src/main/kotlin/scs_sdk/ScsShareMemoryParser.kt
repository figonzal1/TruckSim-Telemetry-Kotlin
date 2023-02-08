/*
 * This file is subject to the terms and conditions defined in file 'LICENSE', which is part of this source code package
 *
 *  Author: Felipe González Alarcón
 *  Email: felipe.gonzalezalarcon94@gmail.com
 *
 *  Project: ETS2-Telemetry
 *  Module: ETS2-Telemetry.main
 *  Last modified: 08-02-23 15:56
 */

package scs_sdk

import com.sun.jna.Pointer
import jna.Ets2Kernel32Impl
import mu.KotlinLogging
import scs_sdk.handler.*
import scs_sdk.model.TelemetryData
import utils.Constants
import utils.exceptions.ReadMemoryException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

var offset = 0

/**
 * Class that is responsible for reading shared memory from RAM
 *
 * @author Felipe Gonzalez
 * @property ets2Kernel used for reading shared memory
 */
class ScsShareMemoryParser(
    private val ets2Kernel: Ets2Kernel32Impl
) {
    private var pointer: Pointer? = null
    private val rawData = ByteArray(Constants.MAP_SIZE)

    val logger = KotlinLogging.logger { }

    /**
     * Retrieve pointer from kernel shared memory
     *
     * @return pointer to shared memory
     */
    suspend fun getSharedMemory(): Pointer? {

        return suspendCoroutine { continuation ->

            pointer = ets2Kernel.openFileMapping()?.let { ets2Kernel.getMapView(it) }

            when {
                pointer != null -> continuation.resume(pointer)
                else -> continuation.resumeWithException(ReadMemoryException("Failed to read file from shared memory"))
            }
        }
    }

    /**
     * Read data from pointer buffer and load into byte Array
     */
    fun readBytes() {
        pointer?.read(0, rawData, 0, Constants.MAP_SIZE)
    }

    /**
     * Parse data from byte array and transform into objects
     *
     * @param callBack function to send back data|
     */
    suspend fun parseBytes(callBack: suspend (TelemetryData) -> Unit) {

        with(rawData) {
            val game = game(this)
            val events = events(this)
            val controls = controls(this)
            val job = job(this)
            val navigation = navigation(this)
            val substances = substances(this)
            val truck = truck(this)
            val trailer = trailer(this)

            callBack(TelemetryData(game, events, controls, job, navigation, substances, truck, trailer))
        }
    }
}