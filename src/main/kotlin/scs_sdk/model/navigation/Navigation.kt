package scs_sdk.model.navigation

data class Navigation(
    val nextRestStop: Int,
    val distance: Float,
    val time: Float,
    val speedLimit: Long
)
