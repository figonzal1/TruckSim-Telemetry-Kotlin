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