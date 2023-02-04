package scs_sdk

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import mu.KotlinLogging
import scs_sdk.model.game.Game
import utils.Constants
import utils.exceptions.ReadMemoryException

private val logger = KotlinLogging.logger { }

var DELAY_TIME: Long = 1000

class ScsTelemetry(
    private val scsShareMemoryParser: ScsShareMemoryParser,
    private var isConnected: Boolean = false
) {

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

    private suspend fun connect(): Boolean {

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

    private suspend fun readData() {
        scsShareMemoryParser.readBytes()
        scsShareMemoryParser.parseBytes { telemetry ->
        }
    }

    private val _sdkActiveFlow = MutableSharedFlow<Boolean>()
    val sdkActiveFlow = _sdkActiveFlow.asSharedFlow()

    private val _game = MutableSharedFlow<Game>()
    val game = _game.asSharedFlow()
}
