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
