/*
 * This file is subject to the terms and conditions defined in file 'LICENSE', which is part of this source code package
 *
 *  Author: Felipe González Alarcón
 *  Email: felipe.gonzalezalarcon94@gmail.com
 *
 *  Project: ETS2-Telemetry
 *  Module: ETS2-Telemetry.main
 *  Last modified: 08-02-23 19:14
 */



package scs_sdk.model.truck

import scs_sdk.model.truck.brakes.Brakes
import scs_sdk.model.truck.engine.Engine
import scs_sdk.model.truck.lights.Lights
import scs_sdk.model.truck.liquids.Liquids
import scs_sdk.model.truck.transmission.CruiseControl
import scs_sdk.model.truck.transmission.Differential
import scs_sdk.model.truck.transmission.Transmission
import scs_sdk.model.utils.Acceleration
import scs_sdk.model.utils.GenericResource
import scs_sdk.model.utils.OrientationVector
import scs_sdk.model.utils.Vector

/**
 *
 */
data class Truck(
    val transmission: Transmission,
    val brakes: Brakes,
    val lights: Lights,
    val liquids: Liquids,
    val engine: Engine,
    val differential: Differential,
    val speed: Long,
    val cruiseControl: CruiseControl,
    val cabin: Cabin<Float>,
    val chassis: Chassis,
    val odometer: Float,
    val isElectricEnabled: Boolean,
    val isWipersEnabled: Boolean,
    val brand: GenericResource,
    val model: GenericResource,
    val licensePlate: LicensePlate,
    val totalDamage: Float,
    val position: Vector<Double>,
    val orientation: OrientationVector<Double>,
    val acceleration: Acceleration<Float>,
    val head: Head<Float>,
    val hook: Hook<Float>,
    val liftAxle: LiftAxle,
    val wheels: List<TruckWheel>
)
