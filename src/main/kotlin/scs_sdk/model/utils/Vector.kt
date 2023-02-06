package scs_sdk.model.utils

data class Vector<T>(
    val x: T,
    val y: T,
    val z: T
)

data class OrientationVector(
    val heading: Float,
    val pitch: Float,
    val roll: Float
)
