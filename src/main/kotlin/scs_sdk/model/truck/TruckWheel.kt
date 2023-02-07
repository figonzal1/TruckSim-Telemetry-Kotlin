package scs_sdk.model.truck

import scs_sdk.model.utils.Vector

data class TruckWheel(
    val substance: Int,
    val radius: Float,
    val suspensionDeflection: Float,
    val velocity: Float,
    val steering: Float,
    val rotation: Float,
    val lift: Float,
    val liftOffset: Float,
    val position: Vector<Float>,
    val isSteerable: Boolean,
    val isSimulated: Boolean,
    val isPowered: Boolean,
    val isLiftable: Boolean,
    val isOnGround: Boolean,
    val damage: Float
)
