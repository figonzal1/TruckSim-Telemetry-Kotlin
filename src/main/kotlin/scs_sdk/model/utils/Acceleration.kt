package scs_sdk.model.utils

data class Acceleration<T>(
    val linearVelocity: Vector<T>? = null,
    val angularVelocity: Vector<T>,
    val linearAcceleration: Vector<T>? = null,
    val angularAcceleration: Vector<T>
)
