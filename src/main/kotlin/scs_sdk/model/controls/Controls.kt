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