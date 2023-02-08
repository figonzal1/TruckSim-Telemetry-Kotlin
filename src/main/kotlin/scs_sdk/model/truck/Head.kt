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

package scs_sdk.model.truck

import scs_sdk.model.utils.Offset
import scs_sdk.model.utils.Vector

data class Head<T>(
    val position: Vector<T>,
    val offset: Offset<T>
)
