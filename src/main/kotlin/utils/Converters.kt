package utils

import scs_sdk.model.GameType
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.math.abs
import kotlin.math.roundToLong


fun ByteArray.getBool(index: Int) = this[index] > 0

fun ByteArray.getUInt(index: Int) =
    ByteBuffer.wrap(this, index, Int.SIZE_BYTES).order(ByteOrder.LITTLE_ENDIAN).int.toUInt()

fun ByteArray.getFloat(index: Int) =
    ByteBuffer.wrap(this, index, Float.SIZE_BYTES).order(ByteOrder.LITTLE_ENDIAN).float

@OptIn(ExperimentalUnsignedTypes::class)
fun ByteArray.getUIntArray(index: Int, count: Int): ArrayList<UInt> {

    val uIntArray = arrayListOf<UInt>()
    var innerIndex = index
    (0 until count).forEach { _ ->
        uIntArray.add(this.getUInt(innerIndex))
        innerIndex += Int.SIZE_BYTES
    }

    return uIntArray
}

fun ByteArray.getFloatArray(index: Int, count: Int): ArrayList<Float> {
    val floatArray = arrayListOf<Float>()
    var innerIndex = index

    (0 until count).forEach { _ ->
        floatArray.add(getFloat(innerIndex))
        innerIndex += Int.SIZE_BYTES
    }
    return floatArray
}

fun ByteArray.getBoolArray(index: Int, count: Int): ArrayList<Boolean> {
    val booleanArray = arrayListOf<Boolean>()
    var innerIndex = index

    (0 until count).forEach { _ ->
        booleanArray.add(getBool(innerIndex))
        innerIndex++
    }
    return booleanArray
}


/**
 * Get gameType depending on the uInt value
 */
fun getGameType(uInt: UInt) = when (uInt) {
    1u -> GameType.ETS2
    2u -> GameType.ATS
    else -> GameType.UNKNOWN
}

fun ByteArray.getSpeedFloat(index: Int) = abs(getFloat(index) * 3.6).roundToLong()