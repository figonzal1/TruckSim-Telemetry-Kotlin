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
 * Class for hold offsets of [Vector] & [OrientationVector]
 *
 * @author Felipe Gonzalez
 * @property position
 * @property orientation
 */
data class Offset<T>(
    val position: Vector<T>,
    val orientation: OrientationVector<T>
)
