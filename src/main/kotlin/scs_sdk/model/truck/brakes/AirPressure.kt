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
