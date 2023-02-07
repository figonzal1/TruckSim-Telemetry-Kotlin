package scs_sdk.model.game

/**
 * Class that hold general information about the game
 *
 * @author Felipe Gonzalez
 *
 * @property sdkActive
 * @property paused
 * @property timestamp
 * @property simulationTimestamp
 * @property renderTimestamp
 * @property multiplayerTimeOffset
 * @property pluginVersion
 * @property version
 * @property gameType
 * @property telemetryVersion
 * @property time
 * @property maxTrailerCount
 * @property scale
 */
data class Game(
    val sdkActive: Boolean,
    val paused: Boolean,
    val timestamp: String? = null,
    val simulationTimestamp: String? = null,
    val renderTimestamp: String? = null,
    val multiplayerTimeOffset: String? = null,
    val pluginVersion: Int,
    val version: Double,
    val gameType: GameType,
    val telemetryVersion: Double,
    val time: GameTime,
    val maxTrailerCount: Int,
    val scale: Int
)
