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
package utils

import scs_sdk.model.game.GameType

/**
 * Transform raw versions to a formatted version
 *
 * @author Felipe Gonzalez
 *
 * @param majorVersion
 * @param minorVersion
 *
 * @return Formatted version double
 */
fun getVersion(majorVersion: UInt, minorVersion: UInt) = "${majorVersion}.${minorVersion}".toDouble()

/**
 * Convert [uInt] to a [GameType]
 *
 * @author Felipe Gonzalez
 * @param uInt raw int
 *
 * @return [GameType] parsed type
 */
fun getGameType(uInt: UInt) = when (uInt) {
    1u -> GameType.ETS2
    2u -> GameType.ATS
    else -> GameType.UNKNOWN
}