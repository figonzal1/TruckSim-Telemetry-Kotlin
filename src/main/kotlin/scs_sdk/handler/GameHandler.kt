/*
 * This file is subject to the terms and conditions defined in file 'LICENSE', which is part of this source code package
 *
 *  Author: Felipe González Alarcón
 *  Email: felipe.gonzalezalarcon94@gmail.com
 *
 *  Project: ETS2-Telemetry
 *  Module: ETS2-Telemetry.main
 *  Last modified: 08-02-23 14:45
 */

/*
 * This file is subject to the terms and conditions defined in file 'LICENSE', which is part of this source code package
 *
 *  Author: Felipe González Alarcón
 *  Email: felipe.gonzalezalarcon94@gmail.com
 *
 *  Project: ETS2-Telemetry
 *  Module: ETS2-Telemetry.main
 *  Last modified: 08-02-23 12:18
 */

/*
 * This file is subject to the terms and conditions defined in file 'LICENSE', which is part of this source code package
 *
 *  Author: Felipe González Alarcón
 *  Email: felipe.gonzalezalarcon94@gmail.com
 *
 *  Project: ETS2-Telemetry
 *  Module: ETS2-Telemetry.main
 *  Last modified: 08-02-23 12:18
 */

package scs_sdk.handler

import scs_sdk.model.game.Game
import scs_sdk.model.game.Timestamp
import scs_sdk.model.game.Versions
import utils.*

/**
 * Parse [ByteArray] with game data and transform to [Game]
 *
 * @author Felipe Gonzalez
 * @param rawData - byte array of game data
 *
 * @return [Game] object
 */
fun game(rawData: ByteArray) = with(rawData) {
    Game(
        sdkActive = getBool(0),
        paused = getBool(4),
        timestamps = Timestamp(
            game = getULong(8).toLong(),
            simulation = getULong(16).toLong(),
            render = getULong(24).toLong()
        ),
        multiplayerTimeOffset = getULong(32).toLong(),
        version = Versions(
            plugin = getUInt(40).toInt(),
            game = getVersion(getUInt(44), getUInt(48)),
            telemetry = getVersion(getUInt(56), getUInt(60))
        ),
        gameType = getGameType(getUInt(52)),
        gameTime = getGameTime(getUInt(64).toDouble()),
        maxTrailerCount = getUInt(92).toInt(),
        scale = getFloat(700).toInt()
    )
}