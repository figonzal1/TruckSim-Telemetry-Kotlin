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

/**
 * Model that hold controls type [ControlsInput|ControlsGame]
 *
 * @author Felipe Gonzalez
 *
 * @property steering
 * @property throttle
 * @property brake
 * @property clutch
 */
sealed class ControlsType(
    val steering: Float,
    val throttle: Float,
    val brake: Float,
    val clutch: Float
) {
    /**
     * Controls related to input
     */
    class ControlsInput(steering: Float, throttle: Float, brake: Float, clutch: Float) :
        ControlsType(steering, throttle, brake, clutch)

    /**
     * Controls related to game input
     */
    class ControlsGame(steering: Float, throttle: Float, brake: Float, clutch: Float) :
        ControlsType(steering, throttle, brake, clutch)
}