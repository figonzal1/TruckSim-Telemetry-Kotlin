import jna.Ets2Kernel32Impl
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging
import scs_sdk.ScsShareMemory
import scs_sdk.ScsTelemetry

val logger = KotlinLogging.logger { }

var DELAY_TIME: Long = 1000

fun main(args: Array<String>) {


    val telemetry = ScsTelemetry(ScsShareMemory(Ets2Kernel32Impl()))

    runBlocking {

        launch {

            while (true) {
                delay(DELAY_TIME)

                val isConnected = telemetry.connect()
                DELAY_TIME = when {
                    isConnected -> {
                        telemetry.readData()
                        1000
                    }

                    else -> 5000
                }
            }
        }

        //Listen changes
        launch {
            telemetry.sdkActiveFlow.collect {
                logger.info { "SdkActive: $it" }
            }

        }
    }
}