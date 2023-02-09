/*
 * This file is subject to the terms and conditions defined in file 'LICENSE', which is part of this source code package
 *
 *  Author: Felipe González Alarcón
 *  Email: felipe.gonzalezalarcon94@gmail.com
 *
 *  Project: TruckSim-Telemetry-Kotlin
 *  Module: TruckSim-Telemetry-Kotlin.main
 *  Last modified: 09-02-23 01:02
 */


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
