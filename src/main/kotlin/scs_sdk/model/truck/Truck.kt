package scs_sdk.model.truck

import scs_sdk.model.truck.brakes.Brakes
import scs_sdk.model.truck.lights.Lights

data class Truck(
    val transmission: Transmission,
    val brakes: Brakes,
    val lights: Lights
)
