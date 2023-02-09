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