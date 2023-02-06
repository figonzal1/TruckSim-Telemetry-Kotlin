package scs_sdk.model.substances

import scs_sdk.model.utils.Vector

data class Substances(
    val linearVelocity: Vector,
    val angularVelocity: Vector,
    val linearAcceleration: Vector,
    val angularAcceleration: Vector
)
