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


package scs_sdk.model.job

/**
 * Class that hold specific data from cargo
 *
 * @author Felipe González
 *
 * @property id
 * @property name
 * @property mass
 * @property unitMass
 * @property damage
 * @property isLoaded
 */
data class JobCargo(
    val id: String,
    val name: String,
    val mass: Float,
    val unitMass: Float,
    val damage: Float,
    val isLoaded: Boolean,
)
