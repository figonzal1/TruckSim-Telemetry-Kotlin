/*
 * This file is subject to the terms and conditions defined in file 'LICENSE', which is part of this source code package
 *
 *  Author: Felipe González Alarcón
 *  Email: felipe.gonzalezalarcon94@gmail.com
 *
 *  Project: ETS2-Telemetry
 *  Module: ETS2-Telemetry.main
 *  Last modified: 08-02-23 12:18
 */

package scs_sdk.model.truck.engine

import scs_sdk.model.truck.liquids.LiquidsType.Oil
import scs_sdk.model.truck.liquids.LiquidsType.Water

data class Engine(
    val oil: Oil,
    val water: Water,
    val battery: Battery,
    val rpm: Rpm,
    val damage: Float,
    val enabled: Boolean
)
