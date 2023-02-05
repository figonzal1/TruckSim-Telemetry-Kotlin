package scs_sdk.model.events

import scs_sdk.model.events.ferry.EventsFerry
import scs_sdk.model.events.fine.EventsFine
import scs_sdk.model.events.job.EventsJob
import scs_sdk.model.events.tollgate.EventsTollgate
import scs_sdk.model.events.train.EventsTrain

data class Events(
    val job: EventsJob,
    val fine: EventsFine,
    val ferry: EventsFerry,
    val train: EventsTrain,
    val tollgate: EventsTollgate
)
