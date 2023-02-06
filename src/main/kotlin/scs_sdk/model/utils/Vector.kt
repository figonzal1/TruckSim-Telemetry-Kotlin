package scs_sdk.model.utils

data class Vector(
    val x: Float,
    val y: Float,
    val z: Float
)

data class OrientationVector(
    val heading: Float,
    val pitch: Float,
    val roll: Float
)
