package scs_sdk.handler

import scs_sdk.model.substances.Substances
import utils.getFloatVector

fun substances(rawData: ByteArray): Substances<Float> = with(rawData) {
    Substances(
        linearVelocity = getFloatVector(1868),
        angularVelocity = getFloatVector(1880),
        linearAcceleration = getFloatVector(1892),
        angularAcceleration = getFloatVector(1904)
    )
}