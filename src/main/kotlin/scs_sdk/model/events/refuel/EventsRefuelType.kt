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
