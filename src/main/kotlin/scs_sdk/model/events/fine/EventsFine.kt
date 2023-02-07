package scs_sdk.model.events.fine

/**
 * Class that hold events information related with fines
 *
 * @author Felipe Gonzalez
 * @property offence type
 * @property amount of the fine
 * @property active [True|False] if event is still active
 */
data class EventsFine(
    val offence: String,
    val amount: Long,
    val active: Boolean
)