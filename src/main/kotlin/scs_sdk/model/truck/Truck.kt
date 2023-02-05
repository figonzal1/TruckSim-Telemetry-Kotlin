package scs_sdk.model.truck

data class Truck(
    val transmission: Transmission
)

data class Transmission(
    val forwardGears: Int,
    val reverseGears: Int,
    val selectorCount: Int,
    val slotsGear: ArrayList<Int>,
    val slotsHandlePosition: List<Int>,
    val slotsSelector: List<Int>,
    val selectedGear: Int,
    val dashboardGear: Int,
    val gearRatiosForward: ArrayList<Float>,
    val gearRatiosReverse: ArrayList<Float>,
    val damage: Float,
    val shifterType: String
)
