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

import scs_sdk.model.navigation.Navigation
import utils.getFloat
import utils.getSpeedLong
import utils.getUInt

/**
 * Parse [ByteArray] with navigation data and transform to [Navigation]
 *
 * @author Felipe Gonzalez
 * @param rawData - byte array of navigation data
 *
 * @return [Navigation] object
 */
fun navigation(rawData: ByteArray) = with(rawData) {
    Navigation(
        nextRestStop = getUInt(500).toInt(),
        distance = getFloat(1060),
        time = getFloat(1064),
        speedLimit = getSpeedLong(1068)
    )
}