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


package scs_sdk.handler

import scs_sdk.model.events.Events
import scs_sdk.model.trailer.Trailer
import scs_sdk.model.trailer.TrailerDamage
import scs_sdk.model.trailer.TrailerWheel
import scs_sdk.model.truck.Hook
import scs_sdk.model.truck.LicensePlate
import scs_sdk.model.truck.LiftAxle
import scs_sdk.model.utils.Acceleration
import scs_sdk.model.utils.GenericResource
import scs_sdk.model.utils.Vector
import utils.*

/**
 * Parse [ByteArray] with trailer data and transform to [Trailer]
 *
 * @author Felipe Gonzalez
 * @param rawData - byte array of trailer data
 *
 * @return [Trailer] object
 */
fun trailer(rawData: ByteArray) = with(rawData) {

    val cargoDamage = getFloat(6152)
    val chassisDamage = getFloat(6156)
    val wheelDamage = getFloat(6160)
    val bodyDamage = getFloat(6164)

    Trailer(
        isAttached = getBool(6080),
        totalDamage = cargoDamage + chassisDamage + wheelDamage + bodyDamage,
        damageParts = TrailerDamage(cargoDamage, chassisDamage, wheelDamage, bodyDamage),
        acceleration = Acceleration(
            linearVelocity = getFloatVector(6616),
            angularVelocity = getFloatVector(6628),
            linearAcceleration = getFloatVector(6640),
            angularAcceleration = getFloatVector(6652)
        ),
        hook = Hook(getFloatVector(6664)),
        position = getDoubleVector(6872),
        orientation = getDoubleOrientedVector(6896),
        brand = GenericResource(getString(7112), getString(7176)),
        model = GenericResource(getString(6920), getString(7240)),
        accessoryId = getString(6984),
        bodyType = getString(7048),
        chainType = getString(7304),
        licencePlate = LicensePlate(
            value = getString(7368),
            country = GenericResource(getString(7432), getString(7496))
        ),
        liftAxle = LiftAxle(getBool(1611), getBool(1612)),
        wheels = retrieveWheels()
    )
}

/**
 * Parse [ByteArray] with events data and transform to [Events]
 *
 * @author Felipe Gonzalez
 * @return [Events] object
 */
private fun ByteArray.retrieveWheels() =
    (0 until Constants.WHEEL_SIZE)
        .map {
            TrailerWheel(
                substance = getUIntArray(6084, Constants.WHEEL_SIZE)[it].toInt(),
                radius = getFloatArray(6552, Constants.WHEEL_SIZE)[it],
                suspensionDeflection = getFloatArray(6168, Constants.WHEEL_SIZE)[it],
                velocity = getFloatArray(6232, Constants.WHEEL_SIZE)[it],
                steering = getFloatArray(6292, Constants.WHEEL_SIZE)[it],
                rotation = getFloatArray(6360, Constants.WHEEL_SIZE)[it],
                lift = getFloatArray(6424, Constants.WHEEL_SIZE)[it],
                liftOffset = getFloatArray(6488, Constants.WHEEL_SIZE)[it],
                position = Vector(
                    x = getFloatArray(6676, Constants.WHEEL_SIZE)[it],
                    y = getFloatArray(6740, Constants.WHEEL_SIZE)[it],
                    z = getFloatArray(6804, Constants.WHEEL_SIZE)[it]
                ),
                isSteerable = getBoolArray(6000, Constants.WHEEL_SIZE)[it],
                isSimulated = getBoolArray(6016, Constants.WHEEL_SIZE)[it],
                isPowered = getBoolArray(6032, Constants.WHEEL_SIZE)[it],
                isLiftable = getBoolArray(6048, Constants.WHEEL_SIZE)[it],
                isOnGround = getBoolArray(6064, Constants.WHEEL_SIZE)[it]
            )
        }


