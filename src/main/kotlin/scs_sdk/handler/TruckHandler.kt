package scs_sdk.handler

import scs_sdk.model.truck.Transmission
import scs_sdk.model.truck.Truck
import scs_sdk.model.truck.brakes.AirPressure
import scs_sdk.model.truck.brakes.AirPressureAlertType.AirPressureAlertEmergency
import scs_sdk.model.truck.brakes.AirPressureAlertType.AirPressureAlertWarning
import scs_sdk.model.truck.brakes.Brakes
import scs_sdk.model.truck.brakes.Retarder
import utils.*

fun truck(rawData: ByteArray) = with(rawData) {
    Truck(
        transmission = Transmission(
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
            shifterType = getString(3196, 16)
        ),
        brakes = Brakes(
            retarder = Retarder(
                steps = getUInt(76).toInt(),
                level = getUInt(108).toInt()
            ),
            airPressure = AirPressure(
                value = getFloat(992),
                warning = AirPressureAlertWarning(
                    factor = getFloat(720),
                    enabled = getBool(1568)
                ),
                emergency = AirPressureAlertEmergency(
                    factor = getFloat(724),
                    enabled = getBool(1569)
                )
            ),
            temperature = getFloat(996),
            parking = getBool(1566),
            motorBreak = getBool(1567)
        )
    )
}
