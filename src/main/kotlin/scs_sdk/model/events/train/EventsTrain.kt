package scs_sdk.model.events.train

import scs_sdk.model.utils.CityType.CityDestination
import scs_sdk.model.utils.CityType.CitySource

data class EventsTrain(
    val source: CitySource,
    val destination: CityDestination,
    val amount: Long,
    val active: Boolean
)
