/*
 * This file is subject to the terms and conditions defined in file 'LICENSE', which is part of this source code package
 *
 *  Author: Felipe González Alarcón
 *  Email: felipe.gonzalezalarcon94@gmail.com
 *
 *  Project: TruckSim-Telemetry-Kotlin
 *  Module: TruckSim-Telemetry-Kotlin.main
 *  Last modified: 09-02-23 01:03
 */

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import scs_sdk.ScsTelemetry

suspend fun main(args: Array<String>) {

    coroutineScope {

        val telemetry = ScsTelemetry()

        launch {
            telemetry.watch(delayTime = 2000L)
        }

        launch {
            //Collect only one value
            telemetry.telemetryFlow.first {
                println("Telemetry data: $it")
                true
            }

            //Collect infinite values
            telemetry.telemetryFlow.collect {
                println("Telemetry data: $it")
            }
        }
    }
}