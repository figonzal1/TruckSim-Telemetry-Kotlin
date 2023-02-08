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

package scs_sdk.model.trailer

import scs_sdk.model.truck.Hook
import scs_sdk.model.truck.LicensePlate
import scs_sdk.model.truck.LiftAxle
import scs_sdk.model.utils.Acceleration
import scs_sdk.model.utils.GenericResource
import scs_sdk.model.utils.OrientationVector
import scs_sdk.model.utils.Vector

data class Trailer(
    val isAttached: Boolean,
    val totalDamage: Float,
    val damageParts: TrailerDamage,
    val acceleration: Acceleration<Float>,
    val hook: Hook<Float>,
    val position: Vector<Double>,
    val orientation: OrientationVector<Double>,
    val brand: GenericResource,
    val model: GenericResource,
    val accessoryId: String,
    val bodyType: String,
    val chainType: String,
    val licencePlate: LicensePlate,
    val liftAxle: LiftAxle,
    val wheels: List<TrailerWheel>
)
