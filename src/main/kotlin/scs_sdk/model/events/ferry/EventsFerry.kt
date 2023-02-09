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


package scs_sdk.model.events.ferry

import scs_sdk.model.utils.CityType.CityDestination
import scs_sdk.model.utils.CityType.CitySource

/**
 * Class that hold events information related with ferry
 *
 * @author Felipe Gonzalez
 * @property source city
 * @property destination city
 * @property amount of ticket
 * @property isActive [True|False] if event is still active
 */
data class EventsFerry(
    val source: CitySource,
    val destination: CityDestination,
    val amount: Long,
    val isActive: Boolean
)
