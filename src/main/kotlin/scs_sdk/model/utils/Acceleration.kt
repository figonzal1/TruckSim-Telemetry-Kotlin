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


package scs_sdk.model.utils

/**
 * Class for hold physics data
 *
 * @author Felipe Gonzalez
 *
 * @property linearVelocity
 * @property linearAcceleration
 * @property angularVelocity
 * @property angularAcceleration
 */
data class Acceleration<T>(
    val linearVelocity: Vector<T>? = null,
    val angularVelocity: Vector<T>,
    val linearAcceleration: Vector<T>? = null,
    val angularAcceleration: Vector<T>
)
