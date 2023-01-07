package scs_sdk

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import mu.KotlinLogging
import utils.Constants
import utils.exceptions.ReadMemoryException

private val logger = KotlinLogging.logger { }

class ScsTelemetry(
    private val scsShareMemory: ScsShareMemory,
    private var isConnected: Boolean = false
) {

    suspend fun connect(): Boolean {

        try {
            val result = scsShareMemory.getSharedMemory()
            isConnected = when (result) {
                null -> false
                else -> true
            }
        } catch (e: ReadMemoryException) {
            logger.error { Constants.ERROR_CONNECTION }
        }
        return isConnected
    }

    suspend fun readData() {
        scsShareMemory.readBytes()
        scsShareMemory.parseBytes {
            _sdkActiveFlow.emit(it)
        }
    }

    private val _sdkActiveFlow = MutableSharedFlow<Boolean>()
    val sdkActiveFlow = _sdkActiveFlow.asSharedFlow()
}
