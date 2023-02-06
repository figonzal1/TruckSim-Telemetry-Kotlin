package scs_sdk.model.substances

import scs_sdk.model.utils.Vector

data class Substances<T>(
    val linearVelocity: Vector<T>,
    val angularVelocity: Vector<T>,
    val linearAcceleration: Vector<T>,
    val angularAcceleration: Vector<T>
)
