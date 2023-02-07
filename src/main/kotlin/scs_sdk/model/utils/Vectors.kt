package scs_sdk.model.utils

data class Vector<T>(
    val x: T,
    val y: T,
    val z: T
)

data class OrientationVector<T>(
    val heading: T,
    val pitch: T,
    val roll: T
)
