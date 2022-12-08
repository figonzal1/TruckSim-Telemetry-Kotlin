package scs_sdk

import com.sun.jna.Pointer
import jna.Ets2Kernel32Impl
import mu.KotlinLogging

class ScsShareMemory(
    private val ets2Kernel: Ets2Kernel32Impl
) {

    private val logger = KotlinLogging.logger { }

    fun connectShareMemory(): Pointer? {

        val handler = ets2Kernel.openFileMapping()

        return when {
            handler != null -> {
                logger.debug { "Retrieving share memory ..." }
                ets2Kernel.getMapView(handler)
            }

            else -> {
                logger.error { "Failed to read file from shared memory" }
                null
            }
        }
    }
}