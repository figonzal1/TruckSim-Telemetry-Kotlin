package scs_sdk

import com.sun.jna.Pointer
import jna.Ets2Kernel32Impl
import mu.KotlinLogging
import utils.Constants
import utils.exceptions.ReadMemoryException
import utils.getBool
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class ScsShareMemory(
    private val ets2Kernel: Ets2Kernel32Impl
) {
    private var pointer: Pointer? = null
    private val rawData = ByteArray(Constants.MAP_SIZE)

    private val logger = KotlinLogging.logger { }

    /**
     * Retrieve pointer from kernel shared memory
     */
    suspend fun getSharedMemory(): Pointer? {

        val handler = ets2Kernel.openFileMapping()

        return suspendCoroutine { continuation ->

            pointer = handler?.let { ets2Kernel.getMapView(it) }

            when {
                pointer != null -> continuation.resume(pointer)
                else -> continuation.resumeWithException(ReadMemoryException("Failed to read file from shared memory"))
            }
        }
    }

    /**
     * Read data from pointer buffer
     */
    fun readBytes() {
        pointer?.read(0, rawData, 0, Constants.MAP_SIZE)
    }

    suspend fun parseBytes(function: suspend (Boolean) -> Unit) {

        //First byte section
        val sdkActive = rawData.getBool(0)
        function(sdkActive)
        //logger.debug { "sdkActive: $sdkActive" }

        val isPaused = rawData.getBool(4)
        //logger.debug { "isPaused: $isPaused" }

        //TODO: Check how to handle timestamp from shared memory
        /*val timestamp = rawData.getULong(8)
        logger.debug { "timeStamp: $timestamp" }*/

        //Second byte section
        val secondZone = 40
        /*logger.debug { "Plugin Version: ${rawData.getUInt(secondZone)}" }
        logger.debug { "Game version mayor: ${rawData.getUInt(secondZone + 4)}" }
        logger.debug { "Game version minor: ${rawData.getUInt(secondZone + 4 * 2)}" }
        logger.debug { "Game type: ${getGameType(rawData.getUInt(secondZone + 4 * 3))}" }
        logger.debug { "Telemetry version major: ${rawData.getUInt(secondZone + 4 * 4)}" }
        logger.debug { "Telemetry version minor: ${rawData.getUInt(secondZone + 4 * 5)}" }

        logger.debug { "Gametime: ${rawData.getUInt(secondZone + 4 * 6)}" }*/
    }
}