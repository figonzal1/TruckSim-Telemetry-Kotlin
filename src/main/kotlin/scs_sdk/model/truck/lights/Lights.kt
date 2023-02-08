/*
 * This file is subject to the terms and conditions defined in file 'LICENSE', which is part of this source code package
 *
 *  Author: Felipe González Alarcón
 *  Email: felipe.gonzalezalarcon94@gmail.com
 *
 *  Project: ETS2-Telemetry
 *  Module: ETS2-Telemetry.main
 *  Last modified: 08-02-23 18:29
 */

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

package scs_sdk.model.truck.lights

/**
 * Class that hold light information
 *
 * @author Felipe Gonzalez
 *
 * @property auxFront
 * @property auxRoof
 * @property dashboardBackLight
 * @property blinker
 * @property isParkingBrakeOn
 * @property isBeamLowOn
 * @property isBeamHighOn
 * @property isBeamLowOn
 * @property isBeamHighOn
 * @property isBeaconOn
 * @property isBrakeOn
 * @property isReverseOn
 * @property isHazardOn
 */
data class Lights(
    val auxFront: Int,
    val auxRoof: Int,
    val dashboardBackLight: Float,
    val blinker: Blinker,
    val isParkingBrakeOn: Boolean,
    val isBeamLowOn: Boolean,
    val isBeamHighOn: Boolean,
    val isBeaconOn: Boolean,
    val isBrakeOn: Boolean,
    val isReverseOn: Boolean,
    val isHazardOn: Boolean
)
