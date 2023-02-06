package scs_sdk.model.truck

import scs_sdk.model.utils.Acceleration
import scs_sdk.model.utils.Offset
import scs_sdk.model.utils.Vector

data class Cabin(
    val damage: Float,
    val position: Vector,
    val acceleration: Acceleration,
    val offset: Offset
)
