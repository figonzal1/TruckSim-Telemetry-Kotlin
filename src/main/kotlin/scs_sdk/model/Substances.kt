package scs_sdk.model

data class Substances(
    val linearVelocity: ArrayList<Float>,
    val angularVelocity: ArrayList<Float>,
    val linearAcceleration: ArrayList<Float>,
    val angularAcceleration: ArrayList<Float>
)
