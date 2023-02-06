package scs_sdk.model.truck

import scs_sdk.model.truck.brakes.Brakes
import scs_sdk.model.truck.engine.Engine
import scs_sdk.model.truck.lights.Lights
import scs_sdk.model.truck.liquids.Liquids
import scs_sdk.model.truck.transmission.CruiseControl
import scs_sdk.model.truck.transmission.Differential
import scs_sdk.model.truck.transmission.Transmission

data class Truck(
    val transmission: Transmission,
    val brakes: Brakes,
    val lights: Lights,
    val liquids: Liquids,
    val engine: Engine,
    val differential: Differential,
    val velocity: Long,
    val cruiseControl: CruiseControl,
    val cabin: Cabin
)
