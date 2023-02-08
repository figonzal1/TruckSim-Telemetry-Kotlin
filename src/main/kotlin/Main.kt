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