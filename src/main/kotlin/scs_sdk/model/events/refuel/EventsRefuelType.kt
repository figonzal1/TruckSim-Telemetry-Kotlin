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


package scs_sdk.model.events.refuel

/**
 * Class that represents refuel event types
 *
 * @author Felipe Gonzalez
 *
 * @property amount of fuel loaded
 * @property isActive [True|False] if event is still active
 */
sealed class EventsRefuelType(
    private val isActive: Boolean,
    private val amount: Float? = null
) {

    /**
     * Class to represent refuel event
     *
     * @property isActive [True|False] if event is still active
     */
    class EventsRefuel(isActive: Boolean) : EventsRefuelType(isActive)

    /**
     * Class to represent refueling payment events
     *
     * @property amount of fuel loaded
     * @property isActive [True|False] if event is still active
     */
    class EventsRefuelPaid(amount: Float, isActive: Boolean) : EventsRefuelType(isActive, amount)
}
