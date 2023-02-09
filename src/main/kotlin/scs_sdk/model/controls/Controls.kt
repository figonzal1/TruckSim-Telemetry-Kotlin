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



package scs_sdk.model.controls

import scs_sdk.model.controls.ControlsType.ControlsGame
import scs_sdk.model.controls.ControlsType.ControlsInput


/**
 * Class that hold information about player controls
 *
 * @author Felipe Gonzalez
 *
 * @property input controls
 * @property game controls
 *
 */
data class Controls(
    val input: ControlsInput,
    val game: ControlsGame
)