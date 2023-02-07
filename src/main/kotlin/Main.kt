import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging
import scs_sdk.ScsTelemetry

val logger = KotlinLogging.logger { }


fun main(args: Array<String>) {

    val telemetry = ScsTelemetry()

    runBlocking {


        //Listen changes
        launch {
            telemetry.watch()
        }

        launch {
            telemetry.sdkActiveFlow.collect {
                logger.info { "SdkActive: $it" }
            }
        }


        /*launch {
            val fisrt = telemetry.sdkActiveFlow.first()
            logger.info { "Sdk first: $fisrt" }
        }*/
    }
}