package scs_sdk.model.truck.brakes

data class Brakes(
    val retarder: Retarder,
    val airPressure: AirPressure,
    val temperature: Float,
    val parking: Boolean,
    val motorBreak: Boolean
)