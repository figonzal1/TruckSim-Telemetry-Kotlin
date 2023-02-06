package scs_sdk.model.utils

data class Acceleration(
    val linearVelocity: Vector,
    val angularVelocity: Vector,
    val linearAcceleration: Vector,
    val angularAcceleration: Vector
)
