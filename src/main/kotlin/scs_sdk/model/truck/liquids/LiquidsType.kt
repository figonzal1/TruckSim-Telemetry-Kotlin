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

    /**
     * Sub class for fuel representation
     */
    class Fuel(
        capacity: Float,
        warning: WarningLevels,
        value: Float,
        avgConsumption: Float,
        range: Float
    ) : LiquidsType(capacity, warning, value, avgConsumption, range)

    /**
     * Subclass for Adblue representation
     */
    class AdBlue(
        capacity: Float,
        warning: WarningLevels,
        value: Float
    ) : LiquidsType(capacity, warning, value)

    /**
     * Subclass for Oil representation
     */
    class Oil(
        temperature: Float,
        pressure: Float,
        warning: WarningLevels
    ) : LiquidsType(temperature, warning, pressure)

    /**
     * Subclass for water representation
     */
    class Water(
        temperature: Float,
        warning: WarningLevels
    ) : LiquidsType(temperature, warning)
}
