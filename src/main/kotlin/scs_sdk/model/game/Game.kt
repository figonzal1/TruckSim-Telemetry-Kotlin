/*
 * This file is subject to the terms and conditions defined in file 'LICENSE', which is part of this source code package
 *
 *  Author: Felipe González Alarcón
 *  Email: felipe.gonzalezalarcon94@gmail.com
 *
 *  Project: TruckSim-Telemetry-Kotlin
 *  Module: TruckSim-Telemetry-Kotlin.main
 *  Last modified: 09-02-23 01:02
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
    val gameTime: Int,
    val maxTrailerCount: Int,
    val scale: Int
)
