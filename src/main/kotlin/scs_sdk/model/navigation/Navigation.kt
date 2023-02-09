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


package scs_sdk.model.navigation

/**
 * Class that hold navigation data
 *
 * @author Felipe Gonzalez
 *
 * @property nextRestStop
 * @property distance
 * @property time
 * @property speedLimit road sector
 */
data class Navigation(
    val nextRestStop: Int,
    val distance: Float,
    val time: Float,
    val speedLimit: Long
)
