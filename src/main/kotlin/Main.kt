import jna.Ets2Kernel32Impl
import mu.KotlinLogging
import scs_sdk.ScsShareMemory
import scs_sdk.ScsTelemetry

val logger = KotlinLogging.logger { }

fun main(args: Array<String>) {


    val telemetry = ScsTelemetry(ScsShareMemory(Ets2Kernel32Impl()))

    logger.debug {
        "isConnected : ${telemetry.connect()}"
    }
}