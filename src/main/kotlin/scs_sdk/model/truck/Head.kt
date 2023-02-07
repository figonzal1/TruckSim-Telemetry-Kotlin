package scs_sdk.model.truck

import scs_sdk.model.utils.Offset
import scs_sdk.model.utils.Vector

data class Head<T>(
    val position: Vector<T>,
    val offset: Offset<T>
)
