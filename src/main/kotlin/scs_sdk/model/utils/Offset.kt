package scs_sdk.model.utils

data class Offset<T>(
    val position: Vector<T>,
    val orientation: OrientationVector
)
