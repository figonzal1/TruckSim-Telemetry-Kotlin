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

import scs_sdk.model.utils.Vector

/**
 * Class that hold wheel data from truck
 *
 * @author Felipe Gonzalez
 *
 * @property substance
 * @property radius
 * @property suspensionDeflection
 * @property velocity
 * @property steering
 * @property rotation
 * @property lift
 * @property liftOffset
 * @property position
 * @property isSteerable
 * @property isSimulated
 * @property isPowered
 * @property isLiftable
 * @property isOnGround
 * @property damage - wheel damage
 */
data class TruckWheel(
    val substance: Int,
    val radius: Float,
    val suspensionDeflection: Float,
    val velocity: Float,
    val steering: Float,
    val rotation: Float,
    val lift: Float,
    val liftOffset: Float,
    val position: Vector<Float>,
    val isSteerable: Boolean,
    val isSimulated: Boolean,
    val isPowered: Boolean,
    val isLiftable: Boolean,
    val isOnGround: Boolean,
    val damage: Float
)
