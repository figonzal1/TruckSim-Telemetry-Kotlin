package scs_sdk.model.truck

import scs_sdk.model.utils.Acceleration
import scs_sdk.model.utils.Offset
import scs_sdk.model.utils.Vector

data class Cabin<T>(
    val damage: Float,
    val position: Vector<T>,
    val acceleration: Acceleration<T>,
    val offset: Offset<T>
)