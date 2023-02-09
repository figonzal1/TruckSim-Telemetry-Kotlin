/*
 * This file is subject to the terms and conditions defined in file 'LICENSE', which is part of this source code package
 *
 *  Author: Felipe González Alarcón
 *  Email: felipe.gonzalezalarcon94@gmail.com
 *
 *  Project: TruckSim-Telemetry-Kotlin
 *  Module: TruckSim-Telemetry-Kotlin.main
 *  Last modified: 09-02-23 01:02
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


package utils

import com.sun.jna.platform.win32.WinNT

object Constants {

    const val SHARED_MEM_FILE_ACCESS = WinNT.SECTION_MAP_READ
    const val SHARED_MEM_FILE_NAME = "Local\\SCSTelemetry"
    const val MAP_SIZE = 32 * 1024
    const val ERROR_CONNECTION = "Waiting for simulator session - Failed to connect"

    const val WHEEL_SIZE = 16
    const val STRING_SIZE: Int = 64
    const val SUBSTANCES: Int = 25
}