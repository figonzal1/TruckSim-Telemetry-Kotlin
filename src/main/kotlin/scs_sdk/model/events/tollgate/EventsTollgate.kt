package scs_sdk.model.events.tollgate

/**
 * Class that hold events information related to tollgates
 *
 * @author Felipe Gonzalez
 * @property amount of ticket
 * @property active [True|False] if event is still active
 */
data class EventsTollgate(
    val amount: Long,
    val active: Boolean
)
