/*
 * This file is subject to the terms and conditions defined in file 'LICENSE', which is part of this source code package
 *
 *  Author: Felipe González Alarcón
 *  Email: felipe.gonzalezalarcon94@gmail.com
 *
 *  Project: ETS2-Telemetry
 *  Module: ETS2-Telemetry.main
 *  Last modified: 08-02-23 12:18
 */

package scs_sdk.model.job

/**
 *
 * @author Felipe Gonzalez
 */
data class Job(
    val source: JobLocation,
    val destination: JobLocation,
    val plannedDistance: Int,
    val cargo: JobCargo,
    val isSpecial: Boolean,
    val market: String,
    val income: Long,
    //TODO: Check this
    val expectedDeliveryTimestamp: Int
)
