/*
 * This file is subject to the terms and conditions defined in file 'LICENSE', which is part of this source code package
 *
 *  Author: Felipe González Alarcón
 *  Email: felipe.gonzalezalarcon94@gmail.com
 *
 *  Project: ETS2-Telemetry
 *  Module: ETS2-Telemetry.main
 *  Last modified: 08-02-23 16:35
 */

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
 *  Class that handle information about jobs
 *
 * @author Felipe Gonzalez
 *
 * @property source city
 * @property destination city
 * @property plannedDistance
 * @property cargo data
 * @property isSpecial
 * @property market
 * @property income
 * @property expectedDeliveryTimestamp
 */
data class Job(
    val source: JobLocation,
    val destination: JobLocation,
    val plannedDistance: Int,
    val cargo: JobCargo,
    val isSpecial: Boolean,
    val market: String,
    val income: Long,
    val expectedDeliveryTimestamp: Int
)
