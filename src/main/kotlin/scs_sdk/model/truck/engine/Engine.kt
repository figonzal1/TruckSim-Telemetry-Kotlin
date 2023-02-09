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


package scs_sdk.model.truck.engine

import scs_sdk.model.truck.liquids.LiquidsType.Oil
import scs_sdk.model.truck.liquids.LiquidsType.Water

/**
 * Class that hold engine data
 *
 * @author Felipe Gonzalez
 *
 * @property oil
 * @property water
 * @property battery
 * @property rpm
 * @property damage
 * @property isEnabled
 */
data class Engine(
    val oil: Oil,
    val water: Water,
    val battery: Battery,
    val rpm: Rpm,
    val damage: Float,
    val isEnabled: Boolean
)
