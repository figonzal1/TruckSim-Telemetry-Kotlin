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