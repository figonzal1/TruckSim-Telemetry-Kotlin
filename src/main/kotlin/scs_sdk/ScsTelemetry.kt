package scs_sdk

import mu.KotlinLogging


class ScsTelemetry(
    private val scsShareMemory: ScsShareMemory
) {

    private val logger = KotlinLogging.logger { }

    private var isConnected: Boolean = false

    fun connect(): Boolean {
        val shareMemory = scsShareMemory.connectShareMemory()

        isConnected = when (shareMemory) {
            null -> {
                logger.error { "Telemetry cannot connect" }
                false
            }

            else -> {
                logger.info { "Telemetry connected" }
                true
            }
        }

        return isConnected
    }
}