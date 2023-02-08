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

package scs_sdk.model.navigation

/**
 * Class that hold navigation data
 *
 * @author Felipe Gonzalez
 *
 * @property nextRestStop
 * @property distance
 * @property time
 * @property speedLimit road sector
 */
data class Navigation(
    val nextRestStop: Int,
    val distance: Float,
    val time: Float,
    val speedLimit: Long
)
