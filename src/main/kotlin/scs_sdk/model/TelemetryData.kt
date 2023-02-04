package scs_sdk.model

/**
 * Main data class for telemetry data
 *
 * @author Felipe Gonzalez
 *
 * @property game related to general game data
 * @property controls related to control data
 */
data class TelemetryData(
    val game: Game,
    val controls: Controls
)