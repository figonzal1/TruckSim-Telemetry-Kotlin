package scs_sdk.model.substances

data class Substances(
    val linearVelocity: Velocity,
    val angularVelocity: Velocity,
    val linearAcceleration: Velocity,
    val angularAcceleration: Velocity
)
