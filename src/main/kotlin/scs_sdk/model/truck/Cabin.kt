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



package scs_sdk.model.truck

import scs_sdk.model.utils.Acceleration
import scs_sdk.model.utils.Offset
import scs_sdk.model.utils.Vector

/**
 * Class that hold information about the cabin truck
 *
 * @author Felipe Gonzalez
 *
 * @property damage chassis
 * @property position
 * @property acceleration
 * @property offset
 */
data class Cabin<T>(
    val damage: Float,
    val position: Vector<T>,
    val acceleration: Acceleration<T>,
    val offset: Offset<T>
)
