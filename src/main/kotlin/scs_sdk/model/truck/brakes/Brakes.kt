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


package scs_sdk.model.truck.brakes

/**
 * Class that hold brake information
 *
 * @author Felipe Gonzalez
 *
 * @property retarder
 * @property airPressure
 * @property temperature
 * @property isParkingBrakeActive
 * @property isMotorBreakActive
 */
data class Brakes(
    val retarder: Retarder,
    val airPressure: AirPressure,
    val temperature: Float,
    val isParkingBrakeActive: Boolean,
    val isMotorBreakActive: Boolean
)