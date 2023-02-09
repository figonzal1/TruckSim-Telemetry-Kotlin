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

/*
 * This file is subject to the terms and conditions defined in file 'LICENSE', which is part of this source code package
 *
 *  Author: Felipe González Alarcón
 *  Email: felipe.gonzalezalarcon94@gmail.com
 *
 *  Project: TruckSim-Telemetry-Kotlin
 *  Module: TruckSim-Telemetry-Kotlin.main
 *  Last modified: 09-02-23 01:02
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

        }
    }
}