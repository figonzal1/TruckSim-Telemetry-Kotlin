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


package scs_sdk.model.game

/**
 * Class related to versioning data
 *
 * @author Felipe Gonzalez
 *
 * @property plugin version
 * @property game version
 * @property telemetry version
 */
data class Versions(val plugin: Int, val game: Double, val telemetry: Double)
