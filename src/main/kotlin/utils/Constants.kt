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

package utils

import com.sun.jna.platform.win32.WinNT

/**
 * Constants used in the library
 *
 * @author Felipe Gonzalez
 */
object Constants {

    /**
     * Memory section constant for shared memory access
     */
    const val SHARED_MEM_FILE_ACCESS = WinNT.SECTION_MAP_READ

    /**
     * Shared memory file name
     */
    const val SHARED_MEM_FILE_NAME = "Local\\SCSTelemetry"

    /**
     * Shared memory mapping size
     */
    const val MAP_SIZE = 32 * 1024

    /**
     * Error message for failed shared memory access
     */
    const val ERROR_CONNECTION = "Waiting for simulator session - Failed to connect"

    /**
     * Data size for wheels data
     */
    const val WHEEL_SIZE = 16

    /**
     * Byte size for string values in shared memory
     */
    const val STRING_SIZE = 64

    /**
     * Data size for substances data
     */
    const val SUBSTANCES = 25
}