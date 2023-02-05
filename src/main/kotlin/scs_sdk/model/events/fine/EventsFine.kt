package scs_sdk.model.events.fine

data class EventsFine(
    val offence: String,
    val amount: Long,
    val active: Boolean
)