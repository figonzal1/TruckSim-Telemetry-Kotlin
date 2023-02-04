package utils

import scs_sdk.model.GameTime
import scs_sdk.model.GameType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.math.floor

/**
 * Function to transform raw versions to a formatted version
 *
 * @author Felipe Gonzalez
 *
 * @param majorVersion
 * @param minorVersion
 *
 * @return Formatted version double
 */
fun getVersion(majorVersion: UInt, minorVersion: UInt) = "${majorVersion}.${minorVersion}".toDouble()

/**
 * Convert rawGameTime to [GameTime]
 *
 * @author Felipe Gonzalez
 *
 * @param rawTime rawGameTime to convert
 * @return [GameTime] parsed
 */
fun getGameTime(rawTime: Double): GameTime {

    with(rawTime) {
        val day = floor(this / 1440 % 7 + 5).toInt()
        val hour = floor(this % 1440 / 60).toInt()
        val minutes = floor(this % 1440 % 60).toInt()

        val dateTime = LocalDateTime.of(0, 1, day, hour, minutes)
        return GameTime(dateTime)
    }
}

/**
 * Convert [uInt] to a [GameType]
 *
 * @author Felipe Gonzalez
 * @param uInt raw int
 *
 * @return [GameType] parsed type
 */
fun getGameType(uInt: UInt) = when (uInt) {
    1u -> GameType.ETS2
    2u -> GameType.ATS
    else -> GameType.UNKNOWN
}

/**
 * Return [GameTime] formatted in special pattern [HH:MM]
 *
 * @author Felipe Gonzalez
 * @return string formatted
 */
fun GameTime.formatGameTime(): String {
    val value = this.value
    return "${value.dayOfWeek}, ${DateTimeFormatter.ofPattern("HH:MM")}"
}