package scs_sdk.handler

import scs_sdk.model.substances.Substances
import scs_sdk.model.utils.Vector
import utils.getFloatVector

fun substances(rawData: ByteArray): Substances = with(rawData) {

    val linearV = getFloatVector(1868)
    val angularV = getFloatVector(1880)
    val linearAcc = getFloatVector(1892)
    val angularAcc = getFloatVector(1904)

    return Substances(
        linearVelocity = Vector(linearV[0], linearV[1], linearV[2]),
        angularVelocity = Vector(angularV[0], angularV[1], angularV[2]),
        linearAcceleration = Vector(linearAcc[0], linearAcc[1], linearAcc[2]),
        angularAcceleration = Vector(angularAcc[0], angularAcc[1], angularAcc[2])
    )
}