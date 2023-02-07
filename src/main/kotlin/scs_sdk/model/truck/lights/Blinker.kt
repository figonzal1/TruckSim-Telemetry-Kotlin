package scs_sdk.model.truck.lights

data class Blinker(
    val left: BlinkerStatus,
    val right: BlinkerStatus
)

data class BlinkerStatus(
    val isEnabled: Boolean,
    val isActive: Boolean
)