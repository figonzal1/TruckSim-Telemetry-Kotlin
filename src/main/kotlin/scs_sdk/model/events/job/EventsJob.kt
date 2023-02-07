package scs_sdk.model.events.job

import scs_sdk.model.events.job.EventsJobType.*

/**
 * Class that hold events information related with Jobs
 *
 * @author Felipe Gonzalez
 *
 * @property delivered event job
 * @property started event job
 * @property cancelled event job
 * @property finished event job
 */
data class EventsJob(
    val delivered: EventsJobDelivered,
    val started: EventsJobStarted,
    val cancelled: EventsJobCancelled,
    val finished: EventsJobFinished
)
