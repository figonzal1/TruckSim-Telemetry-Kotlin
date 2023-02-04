import jna.Ets2Kernel32Impl
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging
import scs_sdk.ScsShareMemoryParser
import scs_sdk.ScsTelemetry

val logger = KotlinLogging.logger { }


fun main(args: Array<String>) {


    val telemetry = ScsTelemetry(ScsShareMemoryParser(Ets2Kernel32Impl()))

    runBlocking {

        //Listen changes
        launch {
            telemetry.watch()

            telemetry.sdkActiveFlow.collect {
                logger.info { "SdkActive: $it" }
            }
        }

        launch {
            val fisrt = telemetry.sdkActiveFlow.first()
            logger.info { "Sdk first: $fisrt" }
        }
    }
}