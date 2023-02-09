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

data class Vector<T>(
    val x: T,
    val y: T,
    val z: T
)

data class OrientationVector<T>(
    val heading: T,
    val pitch: T,
    val roll: T
)
