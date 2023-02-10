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



package scs_sdk.model.truck.transmission

/**
 * Class to hold data from cruise control
 *
 * @author Felipe Gonzalez
 *
 * @property value
 * @property isEnabled
 */
data class CruiseControl(val value: Long, val isEnabled: Boolean)