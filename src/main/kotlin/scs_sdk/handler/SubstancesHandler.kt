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

import scs_sdk.model.substances.Substances
import utils.allSubstancesTypes
import utils.getFloatVector

/**
 * Parse [ByteArray] with substances data and transform to [Substances]
 *
 * @author Felipe Gonzalez
 * @param rawData - byte array of substances data
 *
 * @return [Substances] object
 */
fun substances(rawData: ByteArray) = with(rawData) {
    Substances(
        linearVelocity = getFloatVector(1868),
        angularVelocity = getFloatVector(1880),
        linearAcceleration = getFloatVector(1892),
        angularAcceleration = getFloatVector(1904),
        allTypes = allSubstancesTypes()
    )
}

