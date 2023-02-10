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

import scs_sdk.model.utils.OrientationVector
import scs_sdk.model.utils.Vector
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.math.abs
import kotlin.math.roundToLong

/**
 * Capture boolean values from [ByteArray]
 *
 * @author Felipe Gonzalez
 *
 * @param index position of data
 * @return [Boolean] True | False value
 */
fun ByteArray.getBool(index: Int) = this[index] > 0

/**
 * Capture [String] values from [ByteArray]
 *
 * @author Felipe Gonzalez
 *
 * @param index position of data
 * @return [String] value
 */
fun ByteArray.getString(index: Int, length: Int = Constants.STRING_SIZE): String {
    val area = getSubStringArray(index, length).toByteArray()
    return String(area, Charsets.UTF_8).trim()
}

/**
 * Capture [UInt] values from [ByteArray]
 *
 * @author Felipe Gonzalez
 *
 * @param index position of data
 * @return [UInt] value
 */
fun ByteArray.getUInt(index: Int) =
    ByteBuffer.wrap(this, index, Int.SIZE_BYTES).order(ByteOrder.LITTLE_ENDIAN).int.toUInt()

/**
 * Capture [ULong] values from [ByteArray]
 *
 * @author Felipe Gonzalez
 *
 * @param index position of data
 * @return [ULong] value
 */
fun ByteArray.getULong(index: Int) =
    ByteBuffer.wrap(this, index, Long.SIZE_BYTES).order(ByteOrder.LITTLE_ENDIAN).long.toULong()

/**
 * Capture [Float] values from [ByteArray]
 *
 * @author Felipe Gonzalez
 *
 * @param index position of data
 * @return [Float] value
 */
fun ByteArray.getFloat(index: Int) =
    ByteBuffer.wrap(this, index, Float.SIZE_BYTES).order(ByteOrder.LITTLE_ENDIAN).float

/**
 * Capture [Double] values from [ByteArray]
 *
 * @author Felipe Gonzalez
 *
 * @param index position of data
 * @return [Double] value
 */
fun ByteArray.getDouble(index: Int) =
    ByteBuffer.wrap(this, index, Double.SIZE_BYTES).order(ByteOrder.LITTLE_ENDIAN).double

/**
 * Capture [UIntArray] values from [ByteArray]
 *
 * @author Felipe Gonzalez
 *
 * @param index position of data
 * @param count size of data
 *
 * @return [ArrayList] of [UInt]
 */
fun ByteArray.getUIntArray(index: Int, count: Int): ArrayList<UInt> {

    val uIntArray = arrayListOf<UInt>()
    var innerIndex = index
    (0 until count).forEach { _ ->
        uIntArray.add(this.getUInt(innerIndex))
        innerIndex += Int.SIZE_BYTES
    }

    return uIntArray
}

/**
 * Capture [FloatArray] values from [ByteArray]
 *
 * @author Felipe Gonzalez
 *
 * @param index position of data
 * @param count size of data
 *
 * @return [ArrayList] of [Float]
 */
fun ByteArray.getFloatArray(index: Int, count: Int): ArrayList<Float> {
    val floatArray = arrayListOf<Float>()
    var innerIndex = index

    (0 until count).forEach { _ ->
        floatArray.add(getFloat(innerIndex))
        innerIndex += Int.SIZE_BYTES
    }
    return floatArray
}

/**
 * Capture [BooleanArray] values from [ByteArray]
 *
 * @author Felipe Gonzalez
 *
 * @param index position of data
 * @param count size of data
 *
 * @return [ArrayList] of [Boolean]
 */
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
 * Capture substring from [String]
 *
 * @author Felipe Gonzalez
 *
 * @param index position of data
 * @param length size of data
 *
 * @return [ArrayList] of [Byte]
 */
private fun ByteArray.getSubStringArray(index: Int, length: Int): ArrayList<Byte> {
    val list = arrayListOf<Byte>()
    var innerIndex = index

    (0 until length).forEach { _ ->
        if (this[innerIndex].toInt() != 0) {
            list.add(this[innerIndex])
        }
        innerIndex++
    }
    return list
}

/**
 * Capture [Float] array from [ByteArray] and convert it to [Vector]
 *
 * @author Felipe Gonzalez
 * @param index position of data
 *
 * @return [Vector] object
 */
fun ByteArray.getFloatVector(index: Int) = Vector(
    getFloat(index),
    getFloat(index + 4),
    getFloat(index + 8)
)

/**
 * Capture [Float] array with orientation data from [ByteArray] and convert it to [OrientationVector]
 *
 * @author Felipe Gonzalez
 * @param index position of data
 *
 * @return [OrientationVector] object
 */
fun ByteArray.getFloatOrientationVector(index: Int) = OrientationVector(
    getFloat(index),
    getFloat(index + 4),
    getFloat(index + 8)
)

/**
 * Capture [Double] array from [ByteArray] and convert it to [Vector]
 *
 * @author Felipe Gonzalez
 *
 * @param index position of data
 * @return [Vector] object
 */
fun ByteArray.getDoubleVector(index: Int) = Vector(
    getDouble(index),
    getDouble(index + 8),
    getDouble(index + 16)
)

/**
 * Capture [Double] array with orientation data from [ByteArray] and convert it to [OrientationVector]
 *
 * @author Felipe Gonzalez
 * @param index position of data
 *
 * @return [OrientationVector] object
 */
fun ByteArray.getDoubleOrientedVector(index: Int) = OrientationVector(
    getDouble(index),
    getDouble(index + 8),
    getDouble(index + 16)
)

/**
 * Transform [Long] from [ByteArray] and format to [Long] speed in km/h
 *
 * @param index position of data
 * @return [Long]
 */
fun ByteArray.getSpeedLong(index: Int) = abs(getFloat(index) * 3.6).roundToLong()

/**
 * Capture substances from [ByteArray] and convert it to [ArrayList]
 *
 * @author Felipe Gonzalez
 *
 * @return [ArrayList] of substances
 */
fun ByteArray.allSubstancesTypes(): ArrayList<String> {
    val allSubstancesTypes = arrayListOf<String>()
    var innerIndex = 4400
    for (i in 0 until Constants.SUBSTANCES) {
        val temp = getString(innerIndex)
        if (temp.isNotEmpty()) {
            allSubstancesTypes.add(temp)
        }
        innerIndex += Constants.STRING_SIZE
    }

    return allSubstancesTypes
}