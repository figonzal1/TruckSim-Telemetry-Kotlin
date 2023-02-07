package scs_sdk.model

import scs_sdk.model.controls.Controls
import scs_sdk.model.events.Events
import scs_sdk.model.game.Game
import scs_sdk.model.job.Job
import scs_sdk.model.navigation.Navigation
import scs_sdk.model.substances.Substances
import scs_sdk.model.trailer.Trailer
import scs_sdk.model.truck.Truck

/**
 * Main data class for telemetry data
 *
 * @author Felipe Gonzalez
 *
 * @property game related to general game data
 * @property controls related to control data
 * @property job related to cargo data
 */
data class TelemetryData(
    val game: Game,
    val eventsJob: Events,
    val controls: Controls,
    val job: Job,
    val navigation: Navigation,
    val substances: Substances<Float>,
    val truck: Truck,
    val trailer: Trailer
)