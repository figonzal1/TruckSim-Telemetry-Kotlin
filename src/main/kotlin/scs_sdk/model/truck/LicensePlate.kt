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


package scs_sdk.model.truck

import scs_sdk.model.utils.GenericResource

/**
 * Class related to Truck License Plate
 *
 * @author Felipe Gonzalez
 *
 * @property value
 * @property country
 */
data class LicensePlate(val value: String, val country: GenericResource)
