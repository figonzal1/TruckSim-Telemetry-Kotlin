package scs_sdk.model.events

import scs_sdk.model.events.ferry.EventsFerry
import scs_sdk.model.events.fine.EventsFine
import scs_sdk.model.events.job.EventsJob

data class Events(
    val job: EventsJob,
    val fine: EventsFine,
    val ferry: EventsFerry
)
