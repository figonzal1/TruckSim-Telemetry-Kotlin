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
 * Class related to timestamp data
 *
 * @author Felipe Gonzalez
 *
 * @property game
 * @property simulation
 * @property render
 */
data class Timestamp(val game: Long, val simulation: Long, val render: Long)
