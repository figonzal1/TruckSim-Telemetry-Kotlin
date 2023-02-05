package scs_sdk.handler

import scs_sdk.model.events.Events
import scs_sdk.model.events.ferry.EventsFerry
import scs_sdk.model.events.fine.EventsFine
import scs_sdk.model.events.job.EventsJob
import scs_sdk.model.events.job.EventsJobType.*
import scs_sdk.model.events.tollgate.EventsTollgate
import scs_sdk.model.events.train.EventsTrain
import scs_sdk.model.utils.CityType.CityDestination
import scs_sdk.model.utils.CityType.CitySource
import utils.*

fun events(rawData: ByteArray) = with(rawData) {
    Events(
        job = EventsJob(
            delivered = EventsJobDelivered(
                timeTaken = getUInt(440).toInt(),
                startedTimeStamp = getUInt(444).toInt(),
                deliveredTimeStamp = getUInt(448).toInt(),
                earnedXP = getUInt(640).toInt(),
                cargoDamage = getFloat(1456),
                distance = getUInt(1460).toInt(),
                autoParked = getBool(1613),
                revenue = getULong(4208).toLong(),
                active = getBool(4303)
            ),
            started = EventsJobStarted(
                autoLoaded = getBool(1614),
                active = getBool(4300)
            ),
            cancelled = EventsJobCancelled(
                penalty = getULong(4200).toLong(),
                active = getBool(4302),
                startedTimeStamp = getUInt(444).toInt(),
                cancelledTimestamp = getUInt(448).toInt()

            ),
            finished = EventsJobFinished(getBool(4301))
        ),
        fine = EventsFine(
            offence = getString(3436, 32),
            amount = getULong(4216).toLong(),
            active = getBool(4304)
        ),
        ferry = EventsFerry(
            source = CitySource(getString(3596), getString(3468)),
            destination = CityDestination(getString(3660), getString(3532)),
            amount = getULong(4232).toLong(),
            active = getBool(4306)
        ),
        train = EventsTrain(
            source = CitySource(getString(3852), getString(3724)),
            destination = CityDestination(getString(3916), getString(3788)),
            amount = getULong(4240).toLong(),
            active = getBool(4307)
        ),
        tollgate = EventsTollgate(
            amount = rawData.getULong(4224).toLong(),
            active = rawData.getBool(4305)
        )
        //TODO: Add missing objects ->tollgate, refuel. refuelPaid
    )
}