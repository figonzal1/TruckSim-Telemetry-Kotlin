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
    private val steering: Float,
    private val throttle: Float,
    private val brake: Float,
    private val clutch: Float
) {
    class ControlsInput(steering: Float, throttle: Float, brake: Float, clutch: Float) :
        ControlsType(steering, throttle, brake, clutch)

    class ControlsGame(steering: Float, throttle: Float, brake: Float, clutch: Float) :
        ControlsType(steering, throttle, brake, clutch)
}