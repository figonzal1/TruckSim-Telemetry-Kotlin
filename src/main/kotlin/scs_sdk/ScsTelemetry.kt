/*
 * This file is subject to the terms and conditions defined in file 'LICENSE', which is part of this source code package
 *
 *  Author: Felipe González Alarcón
 *  Email: felipe.gonzalezalarcon94@gmail.com
 *
 *  Project: ETS2-Telemetry
 *  Module: ETS2-Telemetry.main
 *  Last modified: 08-02-23 12:18
 */

/*
 * This file is subject to the terms and conditions defined in file 'LICENSE', which is part of this source code package
 *
 *  Author: Felipe González Alarcón
 *  Email: felipe.gonzalezalarcon94@gmail.com
 *
 *  Project: ETS2-Telemetry
 *  Module: ETS2-Telemetry.main
 *  Last modified: 08-02-23 12:18
 */

package scs_sdk

import jna.Ets2Kernel32Impl
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import mu.KotlinLogging
import scs_sdk.model.TelemetryData
import utils.Constants
import utils.exceptions.ReadMemoryException

private val logger = KotlinLogging.logger { }

var DELAY_TIME: Long = 1000

/**
 * Class that handle basic telemetry data functionality
 *
 * @author Felipe Gonzalez
 */
class ScsTelemetry {

    private var scsShareMemoryParser: ScsShareMemoryParser = ScsShareMemoryParser(Ets2Kernel32Impl())

    private val _telemetryFlow = MutableSharedFlow<TelemetryData>()
    val telemetryFlow = _telemetryFlow.asSharedFlow()

    /**
     * Observer changes in telemetry
     *
     * @author Felipe Gonzalez
     */
    suspend fun watch() {
        while (true) {
            delay(DELAY_TIME)

            DELAY_TIME = when (connect()) {
                true -> {
                    readData()
                    1000
                }

                else -> 5000
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
     * Read and parse data from byte array and then emit values to sharedFlow
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
