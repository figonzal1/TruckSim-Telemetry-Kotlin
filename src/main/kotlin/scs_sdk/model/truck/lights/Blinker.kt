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



package scs_sdk.model.truck.lights

data class Blinker(val left: BlinkerStatus, val right: BlinkerStatus)

data class BlinkerStatus(val isEnabled: Boolean, val isActive: Boolean)