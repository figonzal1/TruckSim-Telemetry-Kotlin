/*
 * This file is subject to the terms and conditions defined in file 'LICENSE', which is part of this source code package
 *
 *  Author: Felipe González Alarcón
 *  Email: felipe.gonzalezalarcon94@gmail.com
 *
 *  Project: ETS2-Telemetry
 *  Module: ETS2-Telemetry.main
 *  Last modified: 08-02-23 19:14
 */



package scs_sdk.model.truck.liquids

import scs_sdk.model.utils.WarningLevels

/**
 * Class that represent different liquids types
 *
 * @author Felipe Gonzalez
 *
 * @property capacity - lts
 * @property warningLevels
 * @property value - lts
 * @property avgConsumption
 * @property range
 * @property pressure - psi
 */
sealed class LiquidsType(
    val capacity: Float? = null,
    val warningLevels: WarningLevels? = null,
    val value: Float? = null,
    val avgConsumption: Float? = null,
    val range: Float? = null,
    val pressure: Float? = null
) {

    class Fuel(
        capacity: Float,
        warning: WarningLevels,
        value: Float,
        avgConsumption: Float,
        range: Float
    ) : LiquidsType(capacity, warning, value, avgConsumption, range)

    class AdBlue(
        capacity: Float,
        warning: WarningLevels,
        value: Float
    ) : LiquidsType(capacity, warning, value)

    class Oil(
        temperature: Float,
        pressure: Float,
        warning: WarningLevels
    ) : LiquidsType(temperature, warning, pressure)

    class Water(
        temperature: Float,
        warning: WarningLevels
    ) : LiquidsType(temperature, warning)
}
