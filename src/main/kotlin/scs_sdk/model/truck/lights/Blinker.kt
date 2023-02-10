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



package scs_sdk.model.truck.lights

/**
 * Class relate to truck blinker lights
 *
 * @author Felipe Gonzalez
 *
 * @property left
 * @property right
 */
data class Blinker(val left: BlinkerStatus, val right: BlinkerStatus)

/**
 * Class related to truck blinker lights status
 *
 * @author Felipe Gonzalez
 *
 * @property isEnabled
 * @property isActive
 */
data class BlinkerStatus(val isEnabled: Boolean, val isActive: Boolean)