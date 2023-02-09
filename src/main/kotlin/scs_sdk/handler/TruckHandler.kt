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

import scs_sdk.model.truck.*
import scs_sdk.model.truck.brakes.AirPressure
import scs_sdk.model.truck.brakes.AirPressureAlertType.AirPressureAlertEmergency
import scs_sdk.model.truck.brakes.AirPressureAlertType.AirPressureAlertWarning
import scs_sdk.model.truck.brakes.Brakes
import scs_sdk.model.truck.brakes.Retarder
import scs_sdk.model.truck.engine.Battery
import scs_sdk.model.truck.engine.Engine
import scs_sdk.model.truck.engine.Rpm
import scs_sdk.model.truck.lights.Blinker
import scs_sdk.model.truck.lights.BlinkerStatus
import scs_sdk.model.truck.lights.Lights
import scs_sdk.model.truck.liquids.Liquids
import scs_sdk.model.truck.liquids.LiquidsType.*
import scs_sdk.model.truck.transmission.CruiseControl
import scs_sdk.model.truck.transmission.Differential
import scs_sdk.model.truck.transmission.Transmission
import scs_sdk.model.utils.*
import utils.*

/**
 * Parse [ByteArray] with truck data and transform to [Truck]
 *
 * @author Felipe Gonzalez
 * @param rawData - byte array of truck data
 *
 * @return [Truck] object
 */
fun truck(rawData: ByteArray) = with(rawData) {

    val transmission = transmission()
    val engine = engine()
    val cabin = cabin()
    val chassis = Chassis(getFloat(1048))
    val wheels = retrieveWheels(this)

    Truck(
        brand = GenericResource(getString(2300), getString(2364)),
        model = GenericResource(getString(2428), getString(2492)),
        licensePlate = LicensePlate(
            value = getString(3212),
            country = GenericResource(getString(3276), getString(3340))
        ),
        transmission = transmission,
        cabin = cabin,
        chassis = chassis,
        engine = engine,
        brakes = brakes(),
        lights = lights(),
        liquids = liquids(),
        differential = Differential(getFloat(744), getBool(1608)),
        speed = getSpeedLong(948),
        cruiseControl = CruiseControl(getSpeedLong(988), getBool(1589)),
        odometer = getFloat(1056),
        isElectricEnabled = getBool(1575),
        isWipersEnabled = getBool(1577),
        totalDamage = transmission.damage + engine.damage + cabin.damage + chassis.damage + wheels[0].damage,
        position = getDoubleVector(2200),
        orientation = getDoubleOrientedVector(2224),
        acceleration = Acceleration(
            linearVelocity = getFloatVector(1868),
            angularVelocity = getFloatVector(1880),
            linearAcceleration = getFloatVector(1892),
            angularAcceleration = getFloatVector(1904)
        ),
        head = Head(
            getFloatVector(1652),
            Offset(getFloatVector(2024), getFloatOrientationVector(2036))
        ),
        hook = Hook(getFloatVector(1664)),
        liftAxle = LiftAxle(getBool(1609), getBool(1610)),
        wheels = wheels
    )
}

private fun ByteArray.transmission() = Transmission(
    forwardGears = getUInt(68).toInt(),
    reverseGears = getUInt(72).toInt(),
    selectorCount = getUInt(84).toInt(),
    slotsGear = getUIntArray(512, 32).map { it.toInt() } as ArrayList<Int>,
    slotsHandlePosition = getUIntArray(184, 32).map { it.toInt() },
    slotsSelector = getUIntArray(312, 32).map { it.toInt() },
    selectedGear = getUInt(504).toInt(),
    dashboardGear = getUInt(508).toInt(),
    gearRatiosForward = getFloatArray(816, 24),
    gearRatiosReverse = getFloatArray(912, 8),
    damage = getFloat(1040),
    shifterType = getString(3196, 16),
    hShifterSelector = getBoolArray(1606, 2)
)

private fun ByteArray.brakes() = Brakes(
    retarder = Retarder(
        steps = getUInt(76).toInt(),
        level = getUInt(108).toInt()
    ),
    airPressure = AirPressure(
        value = getFloat(992),
        warning = AirPressureAlertWarning(
            factor = getFloat(720),
            isEnabled = getBool(1568)
        ),
        emergency = AirPressureAlertEmergency(
            factor = getFloat(724),
            isEnabled = getBool(1569)
        )
    ),
    temperature = getFloat(996),
    isParkingBrakeActive = getBool(1566),
    isMotorBreakActive = getBool(1567)
)

private fun ByteArray.lights() = Lights(
    auxFront = getUInt(112).toInt(),
    auxRoof = getUInt(116).toInt(),
    dashboardBackLight = getFloat(1032),
    blinker = Blinker(
        left = BlinkerStatus(getBool(1578), getBool(1580)),
        right = BlinkerStatus(getBool(1579), getBool(1581))
    ),
    isParkingBrakeOn = getBool(1582),
    isBeamLowOn = getBool(1583),
    isBeamHighOn = getBool(1584),
    isBeaconOn = getBool(1585),
    isBrakeOn = getBool(1586),
    isReverseOn = getBool(1587),
    isHazardOn = getBool(1588)
)

private fun ByteArray.liquids() = Liquids(
    fuel = Fuel(
        capacity = getFloat(704),
        warning = WarningLevels(getFloat(708), getBool(1570)),
        value = getFloat(1000),
        avgConsumption = getFloat(1004),
        range = getFloat(1008)
    ),
    adBlue = AdBlue(
        capacity = getFloat(712),
        warning = WarningLevels(getFloat(716), getBool(1571)),
        value = getFloat(1012)
    ),
)

private fun ByteArray.engine() = Engine(
    oil = Oil(
        pressure = getFloat(1016),
        warning = WarningLevels(getFloat(728), getBool(1572)),
        temperature = getFloat(1020),
    ),
    water = Water(
        temperature = getFloat(1024),
        warning = WarningLevels(getFloat(732), getBool(1573))
    ),
    battery = Battery(
        value = getFloat(1028),
        warning = WarningLevels(getFloat(736), getBool(1574))
    ),
    rpm = Rpm(getFloat(740), getFloat(952)),
    damage = getFloat(1036),
    isEnabled = getBool(1576)
)

private fun ByteArray.cabin() = Cabin(
    damage = getFloat(1044),
    position = getFloatVector(1640),
    acceleration = Acceleration(
        angularVelocity = getFloatVector(1916),
        angularAcceleration = getFloatVector(1928),
    ),
    offset = Offset(
        position = getFloatVector(2000),
        orientation = getFloatOrientationVector(2012)
    )
)

private fun retrieveWheels(rawData: ByteArray): List<TruckWheel> = with(rawData) {

    return (0 until Constants.WHEEL_SIZE)
        .map {
            TruckWheel(
                substance = getUIntArray(120, Constants.WHEEL_SIZE)[it].toInt(),
                radius = getFloatArray(752, Constants.WHEEL_SIZE)[it],
                suspensionDeflection = getFloatArray(1072, Constants.WHEEL_SIZE)[it],
                velocity = getFloatArray(1136, Constants.WHEEL_SIZE)[it],
                steering = getFloatArray(1200, Constants.WHEEL_SIZE)[it],
                rotation = getFloatArray(1264, Constants.WHEEL_SIZE)[it],
                lift = getFloatArray(1328, Constants.WHEEL_SIZE)[it],
                liftOffset = getFloatArray(1392, Constants.WHEEL_SIZE)[it],
                position = Vector(
                    x = getFloatArray(1676, Constants.WHEEL_SIZE)[it],
                    y = getFloatArray(1740, Constants.WHEEL_SIZE)[it],
                    z = getFloatArray(1804, Constants.WHEEL_SIZE)[it]
                ),
                isSteerable = getBoolArray(1500, Constants.WHEEL_SIZE)[it],
                isSimulated = getBoolArray(1516, Constants.WHEEL_SIZE)[it],
                isPowered = getBoolArray(1532, Constants.WHEEL_SIZE)[it],
                isLiftable = getBoolArray(1548, Constants.WHEEL_SIZE)[it],
                isOnGround = getBoolArray(1590, Constants.WHEEL_SIZE)[it],
                damage = getFloat(1052)
            )
        }
}
