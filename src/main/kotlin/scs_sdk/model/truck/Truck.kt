package scs_sdk.model.truck

import scs_sdk.model.truck.brakes.Brakes

data class Truck(
    val transmission: Transmission,
    val brakes: Brakes
)
