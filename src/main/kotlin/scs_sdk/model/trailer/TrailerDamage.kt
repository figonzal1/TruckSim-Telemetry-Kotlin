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

package scs_sdk.model.trailer

/**
 * Class that hold damage by types
 *
 * @author Felipe Gonzalez
 *
 * @property cargo
 * @property chassis
 * @property wheel
 * @property body
 */
data class TrailerDamage(
    val cargo: Float,
    val chassis: Float,
    val wheel: Float,
    val body: Float
)
