/*
 * This file is subject to the terms and conditions defined in file 'LICENSE', which is part of this source code package
 *
 *  Author: Felipe González Alarcón
 *  Email: felipe.gonzalezalarcon94@gmail.com
 *
 *  Project: ETS2-Telemetry
 *  Module: ETS2-Telemetry.main
 *  Last modified: 08-02-23 12:18
 */

package scs_sdk.model.events

import scs_sdk.model.events.ferry.EventsFerry
import scs_sdk.model.events.fine.EventsFine
import scs_sdk.model.events.job.EventsJob
import scs_sdk.model.events.refuel.EventsRefuelType.EventsRefuel
import scs_sdk.model.events.refuel.EventsRefuelType.EventsRefuelPaid
import scs_sdk.model.events.tollgate.EventsTollgate
import scs_sdk.model.events.train.EventsTrain

/**
 * Class that hold all game events
 *
 * @author Felipe Gonzalez
 *
 * @property job events
 * @property fine events
 * @property ferry events
 * @property train events
 * @property tollgate events
 * @property refuel events
 * @property refuelPaid events
 */
data class Events(
    val job: EventsJob,
    val fine: EventsFine,
    val ferry: EventsFerry,
    val train: EventsTrain,
    val tollgate: EventsTollgate,
    val refuel: EventsRefuel,
    val refuelPaid: EventsRefuelPaid
)
