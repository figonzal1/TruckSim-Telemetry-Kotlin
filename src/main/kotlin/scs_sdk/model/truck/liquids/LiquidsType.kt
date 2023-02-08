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

package scs_sdk.model.truck.liquids

import scs_sdk.model.utils.WarningLevels

sealed class LiquidsType {

    data class Fuel(
        val capacity: Float,
        val warning: WarningLevels,
        val value: Float,
        val avgConsumption: Float,
        val range: Float
    ) : LiquidsType()

    data class AdBlue(
        val capacity: Float,
        val warning: WarningLevels,
        val value: Float
    ) : LiquidsType()

    data class Oil(
        val temperature: Float,
        val pressure: Float,
        val warning: WarningLevels
    )

    data class Water(
        val temperature: Float,
        val warning: WarningLevels
    )
}
