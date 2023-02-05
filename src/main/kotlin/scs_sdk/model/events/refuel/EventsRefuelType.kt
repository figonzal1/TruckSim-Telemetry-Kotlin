package scs_sdk.model.events.refuel

sealed class EventsRefuelType {

    data class EventsRefuel(val active: Boolean) : EventsRefuelType()
    data class EventsRefuelPaid(val amount: Float, val active: Boolean) : EventsRefuelType()
}
