/*
 * This file is subject to the terms and conditions defined in file 'LICENSE', which is part of this source code package
 *
 *  Author: Felipe González Alarcón
 *  Email: felipe.gonzalezalarcon94@gmail.com
 *
 *  Project: ETS2-Telemetry
 *  Module: ETS2-Telemetry.main
 *  Last modified: 08-02-23 17:31
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
    class ControlsInput(steering: Float, throttle: Float, brake: Float, clutch: Float) :
        ControlsType(steering, throttle, brake, clutch)

    class ControlsGame(steering: Float, throttle: Float, brake: Float, clutch: Float) :
        ControlsType(steering, throttle, brake, clutch)
}