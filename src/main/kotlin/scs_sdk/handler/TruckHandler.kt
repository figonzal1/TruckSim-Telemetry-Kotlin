package scs_sdk.handler

import scs_sdk.model.truck.Transmission
import scs_sdk.model.truck.Truck
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
import scs_sdk.model.utils.WarningLevels
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
            isParkingBrakeActive = getBool(1566),
            isMotorBreakActive = getBool(1567)
        ),
        lights = Lights(
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
        ),
        liquids = Liquids(
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
        ),
        engine = Engine(
            oil = Oil(
                pressure = getFloat(1016),
                warning = WarningLevels(getFloat(728), getBool(1572)),
                temperature = getFloat(1020),
            ),
            water = Water(
                temperature = rawData.getFloat(1024),
                warning = WarningLevels(rawData.getFloat(732), rawData.getBool(1573))
            ),
            battery = Battery(
                value = rawData.getFloat(1028),
                warning = WarningLevels(rawData.getFloat(736), rawData.getBool(1574))
            ),
            rpm = Rpm(rawData.getFloat(740), rawData.getFloat(952)),
            damage = rawData.getFloat(1036),
            enabled = rawData.getBool(1576)
        )
        //TODO: Implement engine, differential, speed,cruise control, cabin, chassis, odomoeter, electric, wipers, head, hook, acceleration, position, orientation, make,brand,model, plate, damage, liftaxle
    )
}