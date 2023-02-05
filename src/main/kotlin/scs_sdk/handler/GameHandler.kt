package scs_sdk.handler

import scs_sdk.model.game.Game
import utils.*

fun game(rawData: ByteArray) = with(rawData) {
    Game(
        sdkActive = getBool(0),
        paused = getBool(4),
        pluginVersion = getUInt(40).toInt(),
        version = getVersion(getUInt(44), getUInt(48)),
        game = getGameType(getUInt(52)),
        telemetryVersion = getVersion(getUInt(56), getUInt(60)),
        time = getGameTime(getUInt(64).toDouble()),
        maxTrailerCount = getUInt(92).toInt(),
        scale = getFloat(700).toInt()
    )
}