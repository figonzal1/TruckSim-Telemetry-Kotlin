/*
 * This file is subject to the terms and conditions defined in file 'LICENSE', which is part of this source code package
 *
 *  Author: Felipe González Alarcón
 *  Email: felipe.gonzalezalarcon94@gmail.com
 *
 *  Project: ETS2-Telemetry
 *  Module: ETS2-Telemetry.main
 *  Last modified: 08-02-23 14:48
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

package scs_sdk.model.game

/**
 * Class that hold general information about the game
 *
 * @author Felipe Gonzalez
 *
 * @property sdkActive
 * @property paused
 * @property timestamps
 * @property multiplayerTimeOffset
 * @property version
 * @property gameType
 * @property gameTime
 * @property maxTrailerCount
 * @property scale
 */
data class Game(
    val sdkActive: Boolean,
    val paused: Boolean,
    val timestamps: Timestamp,
    val multiplayerTimeOffset: Long,
    val version: Versions,
    val gameType: GameType,
    val gameTime: GameTime,
    val maxTrailerCount: Int,
    val scale: Int
)
