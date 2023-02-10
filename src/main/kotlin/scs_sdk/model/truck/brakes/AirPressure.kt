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

import scs_sdk.model.truck.brakes.AirPressureAlertType.AirPressureAlertEmergency
import scs_sdk.model.truck.brakes.AirPressureAlertType.AirPressureAlertWarning

/**
 * Class that hold air pressure information on truck
 *
 * @author Felipe Gonzalez
 *
 * @property value in PSI
 * @property warning alert
 * @property emergency alert
 */
data class AirPressure(
    val value: Float,
    val warning: AirPressureAlertWarning,
    val emergency: AirPressureAlertEmergency
)

/**
 * Class that represent different types of air pressure alerts
 *
 * @author Felipe Gonzalez
 *
 * @property factor
 * @property isEnabled
 */
sealed class AirPressureAlertType(val factor: Float, val isEnabled: Boolean) {

    /**
     * Class related to emergency alert
     */
    class AirPressureAlertEmergency(factor: Float, isEnabled: Boolean) : AirPressureAlertType(factor, isEnabled)

    /**
     * Class relate to warning alert
     */
    class AirPressureAlertWarning(factor: Float, isEnabled: Boolean) : AirPressureAlertType(factor, isEnabled)
}
