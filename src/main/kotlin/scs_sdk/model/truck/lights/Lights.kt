package scs_sdk.model.truck.lights

data class Lights(
    val auxFront: Int,
    val auxRoof: Int,
    val dashboardBackLight: Float,
    val blinker: Blinker,
    val isParkingBrakeOn: Boolean,
    val isBeamLowOn: Boolean,
    val isBeamHighOn: Boolean,
    val isBeaconOn: Boolean,
    val isBrakeOn: Boolean,
    val isReverseOn: Boolean,
    val isHazardOn: Boolean
)
