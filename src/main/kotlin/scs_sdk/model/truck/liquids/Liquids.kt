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


package scs_sdk.model.truck.liquids

import scs_sdk.model.truck.liquids.LiquidsType.AdBlue
import scs_sdk.model.truck.liquids.LiquidsType.Fuel

/**
 * Class to hold liquids data for a truck
 *
 * @author Felipe Gonzalez
 *
 * @property fuel
 * @property adBlue
 */
data class Liquids(val fuel: Fuel, val adBlue: AdBlue)



