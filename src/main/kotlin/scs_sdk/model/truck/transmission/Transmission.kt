/*
 * This file is subject to the terms and conditions defined in file 'LICENSE', which is part of this source code package
 *
 *  Author: Felipe González Alarcón
 *  Email: felipe.gonzalezalarcon94@gmail.com
 *
 *  Project: ETS2-Telemetry
 *  Module: ETS2-Telemetry.main
 *  Last modified: 08-02-23 18:29
 */

/*
 * This file is subject to the terms and conditions defined in file 'LICENSE', which is part of this source code package
 *
 *  Author: Felipe González Alarcón
 *  Email: felipe.gonzalezalarcon94@gmail.com
 *
 *  Project: ETS2-Telemetry
 *  Module: ETS2-Telemetry.main
 *  Last modified: 08-02-23 16:04
 */

package scs_sdk.model.truck.transmission

/**
 * Class that hold transmission information
 *
 * @author Felipe Gonzalez
 *
 * @property forwardGears
 * @property reverseGears
 * @property selectorCount
 * @property slotsGear
 * @property slotsHandlePosition
 * @property slotsSelector
 * @property selectedGear
 * @property dashboardGear
 * @property gearRatiosForward
 * @property gearRatiosReverse
 * @property damage
 * @property shifterType
 * @property hShifterSelector
 */
data class Transmission(
    val forwardGears: Int,
    val reverseGears: Int,
    val selectorCount: Int,
    val slotsGear: ArrayList<Int>,
    val slotsHandlePosition: List<Int>,
    val slotsSelector: List<Int>,
    val selectedGear: Int,
    val dashboardGear: Int,
    val gearRatiosForward: ArrayList<Float>,
    val gearRatiosReverse: ArrayList<Float>,
    val damage: Float,
    val shifterType: String,
    val hShifterSelector: ArrayList<Boolean>
)