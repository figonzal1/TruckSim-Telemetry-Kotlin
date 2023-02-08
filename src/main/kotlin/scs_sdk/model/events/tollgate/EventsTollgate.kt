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

package scs_sdk.model.events.tollgate

/**
 * Class that hold events information related to tollgates
 *
 * @author Felipe Gonzalez
 * @property amount of ticket
 * @property active [True|False] if event is still active
 */
data class EventsTollgate(
    val amount: Long,
    val active: Boolean
)
