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

package scs_sdk.model.events.refuel

/**
 * Class that represents refuel event types
 *
 * @author Felipe Gonzalez
 */
sealed class EventsRefuelType {

    /**
     * Class to represent refuel event
     *
     * @property active [True|False] if event is still active
     */
    data class EventsRefuel(val active: Boolean) : EventsRefuelType()

    /**
     * Class to represent refueling payment events
     *
     * @property amount of fuel loaded
     * @property active [True|False] if event is still active
     */
    data class EventsRefuelPaid(val amount: Float, val active: Boolean) : EventsRefuelType()
}
