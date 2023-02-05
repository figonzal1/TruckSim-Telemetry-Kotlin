package scs_sdk.handler

import scs_sdk.model.controls.Controls
import scs_sdk.model.controls.ControlsType
import utils.getFloat

fun controls(rawData: ByteArray) = with(rawData) {
    Controls(
        input = ControlsType.ControlsInput(
            steering = getFloat(956),
            throttle = getFloat(960),
            brake = getFloat(964),
            clutch = getFloat(968),
        ),
        game = ControlsType.ControlsGame(
            steering = getFloat(972),
            throttle = getFloat(976),
            brake = getFloat(980),
            clutch = getFloat(984)
        )
    )
}