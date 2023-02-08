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

package scs_sdk.handler

import scs_sdk.model.navigation.Navigation
import utils.getFloat
import utils.getSpeedLong
import utils.getUInt

fun navigation(rawData: ByteArray) = with(rawData) {
    Navigation(
        nextRestStop = getUInt(500).toInt(),
        distance = getFloat(1060),
        time = getFloat(1064),
        speedLimit = getSpeedLong(1068)
    )
}