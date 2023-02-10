/*
 * This file is subject to the terms and conditions defined in file 'LICENSE', which is part of this source code package
 *
 *  Author: Felipe González Alarcón
 *  Email: felipe.gonzalezalarcon94@gmail.com
 *
 *  Project: TruckSim-Telemetry-Kotlin
 *  Module: TruckSim-Telemetry-Kotlin.main
 *  Last modified: 09-02-23 01:02
 */


package scs_sdk

import jna.Ets2Kernel32Impl
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import mu.KotlinLogging
import scs_sdk.model.TelemetryData
import utils.Constants
import utils.exceptions.ReadMemoryException

private val logger = KotlinLogging.logger { }

/**
 * Class that handle basic telemetry data functionality
 *
 * @author Felipe Gonzalez
 */
class ScsTelemetry {

    private var scsShareMemoryParser: ScsShareMemoryParser = ScsShareMemoryParser(Ets2Kernel32Impl())

    private val _telemetryFlow = MutableSharedFlow<TelemetryData>()

    /**
     * Flow for end user consumption
     *
     * @return [SharedFlow] with [TelemetryData]
     */
    val telemetryFlow: SharedFlow<TelemetryData> = _telemetryFlow.asSharedFlow()

    /**
     * Observer changes in [TelemetryData]
     *
     * @author Felipe Gonzalez
     *
     * @param delayTime - frequency to update telemetry. Default: 1000ms
     */
    suspend fun watch(delayTime: Long = 1000) {

        var delay = delayTime

        while (true) {
            delay(delay)

            delay = when (connect()) {
                true -> {
                    readData()
                    delayTime
                }

                else -> 5000L //If the game is not detected, fix delay in 5s
            }
        }
    }

    /**
     * Try to connect to shared memory
     *
     * @author Felipe Gonzalez
     * @return True|False if connected
     */
    private suspend fun connect(): Boolean {

        var isConnected = false
        try {
            isConnected = when (scsShareMemoryParser.getSharedMemory()) {
                null -> false
                else -> true
            }
        } catch (e: ReadMemoryException) {
            logger.error { Constants.ERROR_CONNECTION }
        }
        return isConnected
    }

    /**
     * Read and parse data from byte array and then emit values to [SharedFlow]
     *
     * @author Felipe Gonzalez
     */
    private suspend fun readData() {

        scsShareMemoryParser.apply {
            readBytes()
            parseBytes { _telemetryFlow.emit(it) }
        }
    }
}
