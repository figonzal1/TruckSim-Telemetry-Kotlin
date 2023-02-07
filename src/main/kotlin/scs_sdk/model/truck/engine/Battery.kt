package scs_sdk.model.truck.engine

import scs_sdk.model.utils.WarningLevels

data class Battery(
    val value: Float,
    val warning: WarningLevels
)
