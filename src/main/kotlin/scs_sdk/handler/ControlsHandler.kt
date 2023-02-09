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


package scs_sdk.handler

import scs_sdk.model.controls.Controls
import scs_sdk.model.controls.ControlsType
import utils.getFloat

/**
 * Parse [ByteArray] with controls data and transform to [Controls]
 *
 * @author Felipe Gonzalez
 *
 * @param rawData - byte array of control data
 * @return [Controls] object
 */
fun controls(rawData: ByteArray) = with(rawData) {
    Controls(
        input = ControlsType.ControlsInput(
            steering = getFloat(956),
            throttle = getFloat(960),
            brake = getFloat(964),
            clutch = getFloat(968),
        ),
        game = ControlsType.ControlsGame(
            steering = getFloat(972),
            throttle = getFloat(976),
            brake = getFloat(980),
            clutch = getFloat(984)
        )
    )
}