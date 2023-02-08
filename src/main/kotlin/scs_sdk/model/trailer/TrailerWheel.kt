/*
 * This file is subject to the terms and conditions defined in file 'LICENSE', which is part of this source code package
 *
 *  Author: Felipe González Alarcón
 *  Email: felipe.gonzalezalarcon94@gmail.com
 *
 *  Project: ETS2-Telemetry
 *  Module: ETS2-Telemetry.main
 *  Last modified: 08-02-23 17:38
 */

/*
 * This file is subject to the terms and conditions defined in file 'LICENSE', which is part of this source code package
 *
 *  Author: Felipe González Alarcón
 *  Email: felipe.gonzalezalarcon94@gmail.com
 *
 *  Project: ETS2-Telemetry
 *  Module: ETS2-Telemetry.main
 *  Last modified: 08-02-23 17:26
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

package scs_sdk.model.trailer

import scs_sdk.model.utils.Vector

/**
 * Class that hold wheel data from trailer
 *
 * @author Felipe Gonzalez
 *
 * @property substance
 * @property radius
 * @property suspensionDeflection
 * @property velocity km/h
 * @property steering
 * @property rotation
 * @property lift
 * @property liftOffset
 * @property position
 * @property isSteerable
 * @property isSimulated
 * @property isPowered
 * @property isLiftable
 * @property isOnGround
 */
data class TrailerWheel(
    val substance: Int,
    val radius: Float,
    val suspensionDeflection: Float,
    val velocity: Float,
    val steering: Float,
    val rotation: Float,
    val lift: Float,
    val liftOffset: Float,
    val position: Vector<Float>,
    val isSteerable: Boolean,
    val isSimulated: Boolean,
    val isPowered: Boolean,
    val isLiftable: Boolean,
    val isOnGround: Boolean
)