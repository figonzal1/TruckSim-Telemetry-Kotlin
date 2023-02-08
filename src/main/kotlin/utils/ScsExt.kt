/*
 * This file is subject to the terms and conditions defined in file 'LICENSE', which is part of this source code package
 *
 *  Author: Felipe González Alarcón
 *  Email: felipe.gonzalezalarcon94@gmail.com
 *
 *  Project: ETS2-Telemetry
 *  Module: ETS2-Telemetry.main
 *  Last modified: 08-02-23 12:39
 */

package utils

import scs_sdk.model.game.GameTime
import scs_sdk.model.game.GameType
import java.time.LocalDateTime
import kotlin.math.floor

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
 * Convert [rawTime] to [GameTime]
 *
 * @author Felipe Gonzalez
 *
 * @param rawTime rawGameTime to convert
 * @return [GameTime] parsed
 */
fun getGameTime(rawTime: Double): GameTime {

    with(rawTime) {
        val day = floor(this / 1440 % 7 + 5).toInt()
        val hour = floor(this % 1440 / 60).toInt()
        val minutes = floor(this % 1440 % 60).toInt()

        val dateTime = LocalDateTime.of(0, 1, day, hour, minutes)
        return GameTime(dateTime)
    }
}

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