package scs_sdk.model.events.ferry

import scs_sdk.model.utils.CityType.CityDestination
import scs_sdk.model.utils.CityType.CitySource

data class EventsFerry(
    val source: CitySource,
    val destination: CityDestination,
    val amount: Long,
    val active: Boolean
)
