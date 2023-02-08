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

package scs_sdk.model.utils

/**
 * Class that hold warnings
 *
 * @author Felipe Gonzalez
 *
 * @property factor - minimum number to launch warning
 * @property isEnabled - True|False if warning is launched
 */
data class WarningLevels(val factor: Float, val isEnabled: Boolean)
