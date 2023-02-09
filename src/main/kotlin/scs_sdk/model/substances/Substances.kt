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

package scs_sdk.model.substances

import scs_sdk.model.utils.Vector

data class Substances<T>(
    val linearVelocity: Vector<T>,
    val angularVelocity: Vector<T>,
    val linearAcceleration: Vector<T>,
    val angularAcceleration: Vector<T>,
    val allTypes: ArrayList<String>
)
