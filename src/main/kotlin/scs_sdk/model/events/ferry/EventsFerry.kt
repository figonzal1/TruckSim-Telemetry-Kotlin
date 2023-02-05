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
 * @property active [True|False] if event is still active
 */
data class EventsFerry(
    val source: CitySource,
    val destination: CityDestination,
    val amount: Long,
    val active: Boolean
)
