package utils

import scs_sdk.model.GameType
import java.nio.ByteBuffer
import java.nio.ByteOrder


fun ByteArray.getBool(index: Int) = this[index] > 0

fun ByteArray.getUInt(index: Int) =
    ByteBuffer.wrap(this, index, Int.SIZE_BYTES).order(ByteOrder.LITTLE_ENDIAN).int.toUInt()

@OptIn(ExperimentalUnsignedTypes::class)
fun ByteArray.getUIntArray(index: Int, count: Int): UIntArray {

    val uIntArray = arrayListOf<UInt>()
    var innerIndex = index
    (0 until count).forEach { _ ->
        uIntArray.add(this.getUInt(innerIndex))
        innerIndex += Int.SIZE_BYTES
    }

    return uIntArray.toUIntArray()
}

/**
 * Get gameType depending on the uInt value
 */
fun getGameType(uInt: UInt) = when (uInt) {
    1u -> GameType.ETS2
    2u -> GameType.ATS
    else -> GameType.UNKNOWN
}