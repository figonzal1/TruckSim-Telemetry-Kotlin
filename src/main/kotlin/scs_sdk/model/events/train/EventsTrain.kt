package scs_sdk.model.events.train

import scs_sdk.model.utils.CityType.CityDestination
import scs_sdk.model.utils.CityType.CitySource

/**
 * Class that hold events information related with train
 *
 * @author Felipe Gonzalez
 * @property source city
 * @property destination city
 * @property amount of ticket
 * @property active [True|False] if event is still active
 */
data class EventsTrain(
    val source: CitySource,
    val destination: CityDestination,
    val amount: Long,
    val active: Boolean
)
