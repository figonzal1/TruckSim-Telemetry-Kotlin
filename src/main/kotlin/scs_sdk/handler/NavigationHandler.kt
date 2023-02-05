package scs_sdk.handler

import scs_sdk.model.navigation.Navigation
import utils.getFloat
import utils.getSpeedLong
import utils.getUInt

fun navigation(rawData: ByteArray) = with(rawData) {
    Navigation(
        nextRestStop = getUInt(500).toInt(),
        distance = getFloat(1060),
        time = getFloat(1064),
        speedLimit = getSpeedLong(1068)
    )
}