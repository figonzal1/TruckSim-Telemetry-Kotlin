/*
 * This file is subject to the terms and conditions defined in file 'LICENSE', which is part of this source code package
 *
 *  Author: Felipe González Alarcón
 *  Email: felipe.gonzalezalarcon94@gmail.com
 *
 *  Project: ETS2-Telemetry
 *  Module: ETS2-Telemetry.main
 *  Last modified: 08-02-23 12:18
 */

package scs_sdk.model.truck.brakes

import scs_sdk.model.truck.brakes.AirPressureAlertType.AirPressureAlertEmergency
import scs_sdk.model.truck.brakes.AirPressureAlertType.AirPressureAlertWarning

/**
 *
 * @property value in PSI
 */
data class AirPressure(
    val value: Float,
    val warning: AirPressureAlertWarning,
    val emergency: AirPressureAlertEmergency
)

sealed class AirPressureAlertType {
    data class AirPressureAlertEmergency(val factor: Float, val enabled: Boolean) : AirPressureAlertType()

    data class AirPressureAlertWarning(val factor: Float, val enabled: Boolean) : AirPressureAlertType()
}
