package scs_sdk

import com.sun.jna.Pointer
import jna.Ets2Kernel32Impl
import mu.KotlinLogging
import scs_sdk.model.TelemetryData
import scs_sdk.model.controls.Controls
import scs_sdk.model.controls.ControlsType
import scs_sdk.model.events.Events
import scs_sdk.model.events.ferry.EventsFerry
import scs_sdk.model.events.fine.EventsFine
import scs_sdk.model.events.job.EventsJob
import scs_sdk.model.events.job.EventsJobType.*
import scs_sdk.model.game.Game
import scs_sdk.model.job.Job
import scs_sdk.model.job.JobCargo
import scs_sdk.model.job.JobLocation
import scs_sdk.model.navigation.Navigation
import scs_sdk.model.substances.Substances
import scs_sdk.model.substances.Velocity
import scs_sdk.model.utils.CityType.CityDestination
import scs_sdk.model.utils.CityType.CitySource
import scs_sdk.model.utils.CompanyType.CompanyDestination
import scs_sdk.model.utils.CompanyType.CompanySource
import utils.*
import utils.exceptions.ReadMemoryException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

var offset = 0

class ScsShareMemoryParser(
    private val ets2Kernel: Ets2Kernel32Impl
) {
    private var pointer: Pointer? = null
    private val rawData = ByteArray(Constants.MAP_SIZE)

    private val logger = KotlinLogging.logger { }

    /**
     * Retrieve pointer from kernel shared memory
     */
    suspend fun getSharedMemory(): Pointer? {

        val handler = ets2Kernel.openFileMapping()

        return suspendCoroutine { continuation ->

            pointer = handler?.let { ets2Kernel.getMapView(it) }

            when {
                pointer != null -> continuation.resume(pointer)
                else -> continuation.resumeWithException(ReadMemoryException("Failed to read file from shared memory"))
            }
        }
    }

    /**
     * Read data from pointer buffer
     */
    fun readBytes() {
        pointer?.read(0, rawData, 0, Constants.MAP_SIZE)
    }

    suspend fun parseBytes(callBack: suspend (TelemetryData) -> Unit) {

        val game = game()
        val events = events()
        val controls = controls()
        val job = job()
        val navigation = navigation()
        val substances = substances()



        callBack(TelemetryData(game, events, controls, job, navigation, substances))


        //First byte section
        //val sdkActive = rawData.getBool(0)
        //logger.debug { "sdkActive: $sdkActive" }

        //val isPaused = rawData.getBool(4)
        //logger.debug { "isPaused: $isPaused" }

        //TODO: Check how to handle timestamp from shared memory
        /*val timestamp = rawData.getULong(8)
        logger.debug { "timeStamp: $timestamp" }*/

        //Second byte section
        /*logger.debug { "Plugin Version: ${rawData.getUInt(40)}" }
        logger.debug { "Game version mayor: ${rawData.getUInt(44)}" }
        logger.debug { "Game version minor: ${rawData.getUInt(48)}" }
        logger.debug { "Game type: ${getGameType(rawData.getUInt(52))}" }
        logger.debug { "Telemetry version major: ${rawData.getUInt(56)}" }
        logger.debug { "Telemetry version minor: ${rawData.getUInt(60)}" }

        val rawTime = rawData.getUInt(64).toDouble()
        val day = floor(rawTime / 1440 % 7 + 5).toInt()
        val hour = floor(rawTime % 1440 / 60).toInt()
        val minutes = floor(rawTime % 1440 % 60).toInt()
        val dateTime = LocalDateTime.of(0, 1, day, hour, minutes)
        logger.debug { "Gametime: ${dateTime.dayOfWeek}, ${DateTimeFormatter.ofPattern("HH:MM")}" }

        logger.debug { "ForwardGearValue: ${rawData.getUInt(68)}" }
        logger.debug { "RearGearValue: ${rawData.getUInt(72)}" }
        logger.debug { "RetarderStepCount: ${rawData.getUInt(76)}" }
        logger.debug { "WheelsValue: ${rawData.getUInt(80)}" }
        logger.debug { "SelectorCount ${rawData.getUInt(84)}" }

        logger.debug { "Expected delivery datetime: ${rawData.getUInt(88)}" }

        logger.debug { "MaxTrailerCount: ${rawData.getUInt(92)}" }
        logger.debug { "Trailer cargo units: ${rawData.getUInt(96)}" }

        logger.debug { "Job planned distance: ${rawData.getUInt(100)}" }

        logger.debug { "Truck transmission: ${rawData.getUInt(104)}" }
        logger.debug { "Truck brakes retarder level: ${rawData.getUInt(108)}" }
        logger.debug { "Trucks lights aux front: ${rawData.getUInt(112)}" }
        logger.debug { "Trucks lights aux roof: ${rawData.getUInt(116)}" }

        logger.debug { "Wheels substance: ${rawData.getUIntArray(120, Constants.WHEEL_SIZE)}" }
        logger.debug { "Transmission slots handle position: ${rawData.getUIntArray(184, 32)}" }
        logger.debug { "Transmission slots selector: ${rawData.getUIntArray(312, 32)}" }*/

        //TODO: Check if the information is correct
        /*logger.debug { "Job delivered time taken: ${rawData.getUInt(440)}" }
        logger.debug { "Job cancelled started timestamp: ${rawData.getUInt(444)}" }
        logger.debug { "Job delivered started timestamp: ${rawData.getUInt(444)}" }
        logger.debug { "Job cancelled finished timestamp: ${rawData.getUInt(448)}" }
        logger.debug { "Job delivered finished timestamp: ${rawData.getUInt(448)}" }
         */

        //3rd section
        /*val nextRestStop = rawData.getUInt(500)
        val hour = nextRestStop.toInt() / 60
        val minutes = nextRestStop.toInt() % 60
        logger.debug { "Navigation, nextRestStop: ${hour}h ${minutes}min" }


        logger.debug { "Truck selected gear: ${rawData.getUInt(504)}" }
        logger.debug { "Truck gearDashboard: ${rawData.getUInt(508)}" }
        logger.debug { "Truck transmission slots gear: ${rawData.getUIntArray(512, 32)}" }

         */

        //TODO: ALL BELO VALUES
        logger.debug { "Event delivered earned xp: ${rawData.getUInt(640)}" }

        //4th section
        /*logger.debug { "Game scale: ${rawData.getFloat(700)}" }
        logger.debug { "Truck fuel capacity: ${rawData.getFloat(704)}lt" }
        logger.debug { "Truck fuel warning factor: ${rawData.getFloat(708)}" }
        logger.debug { "Truck ad-blue capacity: ${rawData.getFloat(712)}lt" }
        logger.debug { "Truck ad-blue warning factor: ${rawData.getFloat(716)}" }

        logger.debug { "Truck brakes air pressure warning factor: ${rawData.getFloat(720)}" }
        logger.debug { "Truck brakes air pressure emergency factor: ${rawData.getFloat(724)}" }
        logger.debug { "Truck engine oil pressure warning factor: ${rawData.getFloat(728)}" }
        logger.debug { "Truck engine water T° warning factor: ${rawData.getFloat(732)}" }
        logger.debug { "Truck engine battery voltage warning factor: ${rawData.getFloat(736)}" }


        logger.debug { "Truck max rpm: ${rawData.getFloat(740)}" }
        logger.debug { "Truck differential ratio: ${rawData.getFloat(744)}" }

        logger.debug { "Job cargo mass: ${rawData.getFloat(748)}" }

        logger.debug { "Truck wheels radius: ${rawData.getFloatArray(752, Constants.WHEEL_SIZE)}" }
        logger.debug { "Truck motor gear ratios forward: ${rawData.getFloatArray(816, 24)}" }
        logger.debug { "Truck motor gear ratios reverse: ${rawData.getFloatArray(912, 8)}" }

        logger.debug { "Job cargo unit mass: ${rawData.getFloat(944)}" }

        logger.debug { "Truck dashboard speed value: ${rawData.getSpeedFloat(948)}km/h" }
        logger.debug { "Truck dashboard rpm value : ${rawData.getFloat(952)}" }

        //Controls
        logger.debug { "Controls input steering: ${rawData.getFloat(956)}" }
        logger.debug { "Controls input throttle: ${rawData.getFloat(960)}" }
        logger.debug { "Controls input brake: ${rawData.getFloat(964)}" }
        logger.debug { "Controls input clutch: ${rawData.getSpeedFloat(968)}" }

        logger.debug { "Controls game steering: ${rawData.getFloat(972)}" }
        logger.debug { "Controls game throttle: ${rawData.getFloat(976)}" }
        logger.debug { "Controls game brake: ${rawData.getFloat(980)}" }
        logger.debug { "Controls game clutch: ${rawData.getFloat(984)}" }

        logger.debug { "Cruise control: ${rawData.getSpeedFloat(988)}" }

        logger.debug { "Truck brake air pressure value: ${rawData.getFloat(992)}psi" }
        logger.debug { "Truck brake temperature value: ${rawData.getFloat(996)}°C" }

        logger.debug { "Truck fuel value: ${rawData.getFloat(1000)}" }
        logger.debug { "Truck fuel avg consumption: ${rawData.getFloat(1004)}" }
        logger.debug { "Truck fuel range: ${rawData.getFloat(1008)}" }
        logger.debug { "Truck ad-blue value: ${rawData.getFloat(1012)}" }

        logger.debug { "Truck engine oil pressure value: ${rawData.getFloat(1016)}psi" }
        logger.debug { "Truck engine oil temperature value: ${rawData.getFloat(1020)}°C" }
        logger.debug { "Truck engine water temperature value: ${rawData.getFloat(1024)}°C" }
        logger.debug { "Truck engine battery voltage value: ${rawData.getFloat(1028)} volts" }

        //Lights
        logger.debug { "Truck light dashboard backlight: ${rawData.getFloat(1032)}" }

        //Damage
        logger.debug { "Truck engine damage: ${rawData.getFloat(1036)}%" }
        logger.debug { "Truck transmission damage: ${rawData.getFloat(1040) * 100}%" }
        logger.debug { "Truck cabin damage: ${rawData.getFloat(1044) * 100}%" }
        logger.debug { "Truck chassis damage: ${rawData.getFloat(1048) * 100}%" }
        logger.debug { "Truck wheel damage: ${rawData.getFloat(1052) * 100}%" }

        logger.debug { "Truck odometer: ${rawData.getFloat(1056)}Km" }

        logger.debug { "Navigation distance: ${rawData.getFloat(1060)}Km" }
        logger.debug { "Navigation time: ${rawData.getFloat(1064)}" }
        logger.debug { "Navigation speed limit: ${rawData.getSpeedFloat(1068)}km/h" }

        logger.debug { "Truck wheels suspension deflection ${rawData.getFloatArray(1072, Constants.WHEEL_SIZE)}" }

        logger.debug { "Truck wheels velocity: ${rawData.getFloatArray(1136, Constants.WHEEL_SIZE)}" }
        logger.debug { "Truck wheels steering: ${rawData.getFloatArray(1200, Constants.WHEEL_SIZE)}" }
        logger.debug { "Truck wheels rotation: ${rawData.getFloatArray(1264, Constants.WHEEL_SIZE)}" }
        logger.debug { "Truck wheels lift: ${rawData.getFloatArray(1328, Constants.WHEEL_SIZE)}" }
        logger.debug { "Truck wheels lift offset: ${rawData.getFloatArray(1392, Constants.WHEEL_SIZE)}" }


        logger.debug { "Event job delivered cargo damage: ${rawData.getFloat(1456)}" }
        logger.debug { "Event job delivered distance: ${rawData.getUInt(1460)}" }
        logger.debug { "Event refuel paid amount: ${rawData.getFloat(1464)}" }

        logger.debug { "Job cargo damage: ${rawData.getFloat(1468)}" }

        //5th section
        logger.debug { "Wheels steerable: ${rawData.getBoolArray(1500, Constants.WHEEL_SIZE)}" }
        logger.debug { "Wheels simulated: ${rawData.getBoolArray(1516, Constants.WHEEL_SIZE)}" }
        logger.debug { "Wheels powered: ${rawData.getBoolArray(1532, Constants.WHEEL_SIZE)}" }
        logger.debug { "Wheels liftable: ${rawData.getBoolArray(1548, Constants.WHEEL_SIZE)}" }

        logger.debug { "Job cargo isLoaded: ${rawData.getBool(1564)}" }
        logger.debug { "Job is special: ${rawData.getBool(1565)}" }

        logger.debug { "Truck brakes parking enable: ${rawData.getBool(1566)}" }
        logger.debug { "Truck brakes motor enabled: ${rawData.getBool(1567)}" }
        logger.debug { "Truck brakes airPressure warning enabled: ${rawData.getBool(1568)}" }
        logger.debug { "Truck brakes airPressure emergency enabled: ${rawData.getBool(1569)}" }
        logger.debug { "Truck fuel warning enabled: ${rawData.getBool(1570)}" }
        logger.debug { "Truck adblue warning enabled: ${rawData.getBool(1571)}" }
        logger.debug { "Truck engine oilPressure warning enabled: ${rawData.getBool(1572)}" }
        logger.debug { "Truck engine water temp warning enabled: ${rawData.getBool(1573)}" }
        logger.debug { "Truck engine battery warning enabled: ${rawData.getBool(1574)}" }
        logger.debug { "Truck electric enabled: ${rawData.getBool(1575)}" }
        logger.debug { "Truck engine enabled: ${rawData.getBool(1576)}" }
        logger.debug { "Truck wipers enabled: ${rawData.getBool(1577)}" }

        //Lights
        logger.debug { "Truck lights blinker left enabled: ${rawData.getBool(1578)}" }
        logger.debug { "Truck lights blinker right enabled: ${rawData.getBool(1579)}" }
        logger.debug { "Truck lights blinker left active: ${rawData.getBool(1580)}" }
        logger.debug { "Truck lights blinker right active: ${rawData.getBool(1581)}" }
        logger.debug { "Truck lights parking enabled: ${rawData.getBool(1582)}" }
        logger.debug { "Truck lights beamLow enabled: ${rawData.getBool(1583)}" }
        logger.debug { "Truck lights beamHigh enabled: ${rawData.getBool(1584)}" }
        logger.debug { "Truck lights beacon enabled: ${rawData.getBool(1585)}" }
        logger.debug { "Truck lights brake enabled: ${rawData.getBool(1586)}" }
        logger.debug { "Truck lights reverse enabled: ${rawData.getBool(1587)}" }
        logger.debug { "Truck lights hazard enabled: ${rawData.getBool(1588)}" }
        logger.debug { "Truck cruise control enabled: ${rawData.getBool(1589)}" }
        logger.debug { "Truck wheels on ground: ${rawData.getBoolArray(1590, Constants.WHEEL_SIZE)}" }
        logger.debug { "Truck transmission hshifter selector: ${rawData.getBoolArray(1606, 2)}" }
        logger.debug { "Truck differential lock enabled: ${rawData.getBool(1608)}" }
        logger.debug { "Truck liftAxle enabled: ${rawData.getBool(1609)}" }
        logger.debug { "Truck liftAxle indicator enabled: ${rawData.getBool(1610)}" }
        logger.debug { "Trailer liftAxle enabled: ${rawData.getBool(1611)}" }
        logger.debug { "Trailer liftAxle indicator enabled: ${rawData.getBool(1612)}" }
        logger.debug { "Events job delivered auto-parked: ${rawData.getBool(1613)}" }
        logger.debug { "Events job started autoloader: ${rawData.getBool(1614)}" }

        //6th section
        logger.debug { "Truck positioning cabin: ${rawData.getFloatVector(1640)}" }
        logger.debug { "Truck positioning head: ${rawData.getFloatVector(1652)}" }
        logger.debug { "Truck positioning hook: ${rawData.getFloatVector(1664)}" }

        logger.debug { "Truck wheels position X: ${rawData.getFloatArray(1676, Constants.WHEEL_SIZE)}" }
        logger.debug { "Truck wheels position Y: ${rawData.getFloatArray(1740, Constants.WHEEL_SIZE)}" }
        logger.debug { "Truck wheels position Z: ${rawData.getFloatArray(1804, Constants.WHEEL_SIZE)}" }

        //Velocity values
        logger.debug { "Linear velocity: ${rawData.getFloatVector(1868)}"}
        logger.debug { "Angular velocity: ${rawData.getFloatVector(1880)}"}

        //Acceleration
        logger.debug { "Linear acceleration: ${rawData.getFloatVector(1892)}"}
        logger.debug { "Angular acceleration: ${rawData.getFloatVector(1904)}"}

        //7th section
        logger.debug { "Truck cabin offset position: ${rawData.getFloatVector(2000)}" }
        logger.debug { "Truck cabin offset orientation: ${rawData.getFloatVector(2012)}" }
        logger.debug { "Truck head offset position: ${rawData.getFloatVector(2024)}" }
        logger.debug { "Truck head offset orientation: ${rawData.getFloatVector(2036)}" }

        //8th section
        logger.debug { "Truck position: ${rawData.getDoubleVector(2200)}" }
        logger.debug { "Truck orientation: ${rawData.getDoubleVector(2224)}" }

        //9th section
        logger.debug { "Truck brand id: ${rawData.getString(2300)}" }
        logger.debug { "Truck brand name: ${rawData.getString(2364)}" }
        logger.debug { "Truck id: ${rawData.getString(2428)}" }
        logger.debug { "Truck model name: ${rawData.getString(2492)}" }

        logger.debug { "Job cargo id: ${rawData.getString(2556)}" }
        logger.debug { "Job cargo name: ${rawData.getString(2620)}" }

        logger.debug { "Job cargo destination id: ${rawData.getString(2684)}" }
        logger.debug { "Job cargo destination name: ${rawData.getString(2748)}" }
        logger.debug { "Job cargo company destination id: ${rawData.getString(2812)}" }
        logger.debug { "Job cargo company destination name: ${rawData.getString(2876)}" }

        logger.debug { "Job cargo city source id: ${rawData.getString(2940)}" }
        logger.debug { "Job cargo city source name: ${rawData.getString(3004)}" }

        logger.debug { "Job cargo company source id: ${rawData.getString(3068)}" }
        logger.debug { "Job cargo company source name: ${rawData.getString(3132)}" }

        logger.debug { "Type shift: ${rawData.getString(3196, 16)}" }

        logger.debug { "License Plate: ${rawData.getString(3212)}" }
        logger.debug { "License Plate Country id: ${rawData.getString(3276)}" }
        logger.debug { "License Plate Country name: ${rawData.getString(3340)}" }

        logger.debug { "Job market: ${rawData.getString(3404, 32)}" }
        logger.debug { "Fined Event Offence: ${rawData.getString(3436, 32)}" }

        //ferry
        logger.debug { "Ferry source name: ${rawData.getString(3468)}" }
        logger.debug { "Ferry destination name: ${rawData.getString(3532)}" }
        logger.debug { "Ferry source id: ${rawData.getString(3596)}" }
        logger.debug { "Ferry destination id: ${rawData.getString(3660)}" }

        //Train
        logger.debug { "Train source name: ${rawData.getString(3724)}" }
        logger.debug { "Train target name: ${rawData.getString(3788)}" }
        logger.debug { "Train source id: ${rawData.getString(3852)}" }
        logger.debug { "Train target id: ${rawData.getString(3916)}" }+



        //10th section
        logger.debug { "Job income: $${rawData.getULong(4000)}" }

        //11th section
        logger.debug { "Job cancelled penalty: ${rawData.getULong(4200)}" }
        logger.debug { "Job delivered revenue: ${rawData.getULong(4208)}" }
        logger.debug { "Job fined event amount: ${rawData.getULong(4216)}" }
        logger.debug { "Job tollgate event pay amount: ${rawData.getULong(4224)}" }
        logger.debug { "Job ferry event pay amount: ${rawData.getULong(4232)}" }
        logger.debug { "Job train event pay amount: ${rawData.getULong(4240)}" }

        //12th section
        logger.debug { "Special event on job started: ${rawData.getBool(4300)}" }
        logger.debug { "Special event job finished: ${rawData.getBool(4301)}" }
        logger.debug { "Special event job cancelled: ${rawData.getBool(4302)}" }
        logger.debug { "Special event job delivered: ${rawData.getBool(4303)}" }
        logger.debug { "Special event fined: ${rawData.getBool(4304)}" }
        logger.debug { "Special event tollgate: ${rawData.getBool(4305)}" }
        logger.debug { "Special event ferry: ${rawData.getBool(4306)}" }
        logger.debug { "Special event train: ${rawData.getBool(4307)}" }

        logger.debug { "Special event refuel: ${rawData.getBool(4308)}" }
        logger.debug { "Special event refuel payed: ${rawData.getBool(4309)}" }

        //13th section
        var innerIndex = 4400
        for (i in 0 until Constants.SubStances) {
            val temp = rawData.getString(innerIndex)
            if (temp.isNotEmpty()) {
                logger.debug { "Substances: $temp" }
            }
            innerIndex += Constants.STRING_SIZE
        }

        //14th section
        logger.debug { "Trailer wheels steerable: ${rawData.getBoolArray(6000, Constants.WHEEL_SIZE)}" }
        logger.debug { "Trailer wheels simulated: ${rawData.getBoolArray(6016, Constants.WHEEL_SIZE)}" }
        logger.debug { "Trailer wheels powered: ${rawData.getBoolArray(6032, Constants.WHEEL_SIZE)}" }
        logger.debug { "Trailer wheels liftable: ${rawData.getBoolArray(6048, Constants.WHEEL_SIZE)}" }
        logger.debug { "Trailer wheels on ground: ${rawData.getBoolArray(6064, Constants.WHEEL_SIZE)}" }
        logger.debug { "Trailer attached: ${rawData.getBool(6080)}" }

        logger.debug { "Trailer Wheels substance: ${rawData.getUIntArray(6084, Constants.WHEEL_SIZE)}" }
        logger.debug { "Trailer Wheels count: ${rawData.getUInt(6148)}" }

        logger.debug { "Trailer cargo damage: ${rawData.getFloat(6152) * 100}%" }
        logger.debug { "Trailer chassis damage: ${rawData.getFloat(6156) * 100}%" }
        logger.debug { "Trailer wheels damage: ${rawData.getFloat(6160) * 100}%" }
        logger.debug { "Trailer body damage: ${rawData.getFloat(6164) * 100}%" }

        logger.debug { "Trailer wheel suspension deflection ${rawData.getFloatArray(6168, Constants.WHEEL_SIZE)}" }
        logger.debug { "Trailer wheel velocity ${rawData.getFloatArray(6232, Constants.WHEEL_SIZE)}" }
        logger.debug { "Trailer wheel steering ${rawData.getFloatArray(6292, Constants.WHEEL_SIZE)}" }
        logger.debug { "Trailer wheel rotation ${rawData.getFloatArray(6360, Constants.WHEEL_SIZE)}" }
        logger.debug { "Trailer wheel lift ${rawData.getFloatArray(6424, Constants.WHEEL_SIZE)}" }
        logger.debug { "Trailer wheel liftOffset ${rawData.getFloatArray(6488, Constants.WHEEL_SIZE)}" }
        logger.debug { "Trailer wheel radius ${rawData.getFloatArray(6552, Constants.WHEEL_SIZE)}" }

        logger.debug { "Trailer linear velocity: ${rawData.getFloatVector(6616)}"}
        logger.debug { "Trailer angular velocity: ${rawData.getFloatVector(6628)}"}
        logger.debug { "Trailer linear acceleration: ${rawData.getFloatVector(6640)}"}
        logger.debug { "Trailer angular acceleration: ${rawData.getFloatVector(6652)}"}
        logger.debug { "Trailer positioning hook: ${rawData.getFloatVector(6664)}" }

        logger.debug { "Trailer wheels position X: ${rawData.getFloatArray(6676, Constants.WHEEL_SIZE)}" }
        logger.debug { "Trailer wheels position Y: ${rawData.getFloatArray(6740, Constants.WHEEL_SIZE)}" }
        logger.debug { "Trailer wheels position Z: ${rawData.getFloatArray(6804, Constants.WHEEL_SIZE)}" }

        logger.debug { "Truck position: ${rawData.getDoubleVector(6872)}" }
        logger.debug { "Truck orientation: ${rawData.getDoubleVector(6896)}" }
        logger.debug { "Trailer model id: ${rawData.getString(6920)}" }
        logger.debug { "Trailer accessory id: ${rawData.getString(6984)}" }
        logger.debug { "Trailer body type: ${rawData.getString(7048)}" }
        logger.debug { "Trailer maker id: ${rawData.getString(7112)}" }
        logger.debug { "Trailer maker name: ${rawData.getString(7176)}" }
        logger.debug { "Trailer model name: ${rawData.getString(7240)}" }
        logger.debug { "Trailer chain type: ${rawData.getString(7304)}" }

        logger.debug { "Trailer License Plate: ${rawData.getString(7368)}" }
        logger.debug { "Trailer License Plate Country id: ${rawData.getString(7432)}" }
        logger.debug { "Trailer License Plate Country name: ${rawData.getString(7496)}" }

         */
    }

    private fun game() = Game(
        sdkActive = rawData.getBool(0),
        paused = rawData.getBool(4),
        pluginVersion = rawData.getUInt(40).toInt(),
        version = getVersion(rawData.getUInt(44), rawData.getUInt(48)),
        game = getGameType(rawData.getUInt(52)),
        telemetryVersion = getVersion(rawData.getUInt(56), rawData.getUInt(60)),
        time = getGameTime(rawData.getUInt(64).toDouble()),
        maxTrailerCount = rawData.getUInt(92).toInt(),
        scale = rawData.getFloat(700).toInt()
    )

    private fun events() = Events(
        job = EventsJob(
            delivered = EventsJobDelivered(
                timeTaken = rawData.getUInt(440).toInt(),
                startedTimeStamp = rawData.getUInt(444).toInt(),
                deliveredTimeStamp = rawData.getUInt(448).toInt(),
                earnedXP = rawData.getUInt(640).toInt(),
                cargoDamage = rawData.getFloat(1456),
                distance = rawData.getUInt(1460).toInt(),
                autoParked = rawData.getBool(1613),
                revenue = rawData.getULong(4208).toLong(),
                active = rawData.getBool(4303)
            ),
            started = EventsJobStarted(
                autoLoaded = rawData.getBool(1614),
                active = rawData.getBool(4300)
            ),
            cancelled = EventsJobCancelled(
                penalty = rawData.getULong(4200).toLong(),
                active = rawData.getBool(4302),
                startedTimeStamp = rawData.getUInt(444).toInt(),
                cancelledTimestamp = rawData.getUInt(448).toInt()

            ),
            finished = EventsJobFinished(rawData.getBool(4301))
        ),
        fine = EventsFine(
            offence = rawData.getString(3436, 32),
            amount = rawData.getULong(4216).toLong(),
            active = rawData.getBool(4304)
        ),
        ferry = EventsFerry(
            source = CitySource(rawData.getString(3596), rawData.getString(3468)),
            destination = CityDestination(rawData.getString(3660), rawData.getString(3532)),
            amount = rawData.getULong(4232).toLong(),
            active = rawData.getBool(4306)

        )
    )


    private fun controls() = Controls(
        input = ControlsType.ControlsInput(
            steering = rawData.getFloat(956),
            throttle = rawData.getFloat(960),
            brake = rawData.getFloat(964),
            clutch = rawData.getFloat(968),
        ),
        game = ControlsType.ControlsGame(
            steering = rawData.getFloat(972),
            throttle = rawData.getFloat(976),
            brake = rawData.getFloat(980),
            clutch = rawData.getFloat(984)
        )
    )

    private fun job() = Job(
        source = JobLocation(
            jobCity = CitySource(rawData.getString(2940), rawData.getString(3004)),
            jobCompany = CompanySource(rawData.getString(3068), rawData.getString(3132))
        ),
        destination = JobLocation(
            jobCity = CityDestination(rawData.getString(2684), rawData.getString(2748)),
            jobCompany = CompanyDestination(rawData.getString(2812), rawData.getString(2876))
        ),
        cargo = JobCargo(
            id = rawData.getString(2556),
            name = rawData.getString(2620),
            mass = rawData.getFloat(748),
            unitMass = rawData.getFloat(944),
            damage = rawData.getFloat(6152),
            isLoaded = rawData.getBool(1564)
        ),
        //TODO: CHECK EXPECTED DELIVERY TIMESTAMP
        expectedDeliveryTimestamp = rawData.getUInt(88).toInt(),
        plannedDistance = rawData.getUInt(100).toInt(),
        income = rawData.getULong(4000).toLong(),
        market = rawData.getString(3404, 32),
        isSpecial = rawData.getBool(1565)
    )

    private fun navigation() = Navigation(
        nextRestStop = rawData.getUInt(500).toInt(),
        distance = rawData.getFloat(1060),
        time = rawData.getFloat(1064),
        speedLimit = rawData.getSpeedLong(1068)
    )

    private fun substances(): Substances {

        val linearV = rawData.getFloatVector(1868)
        val angularV = rawData.getFloatVector(1880)
        val linearAcc = rawData.getFloatVector(1892)
        val angularAcc = rawData.getFloatVector(1904)

        return Substances(
            linearVelocity = Velocity(linearV[0], linearV[1], linearV[2]),
            angularVelocity = Velocity(angularV[0], angularV[1], angularV[2]),
            linearAcceleration = Velocity(linearAcc[0], linearAcc[1], linearAcc[2]),
            angularAcceleration = Velocity(angularAcc[0], angularAcc[1], angularAcc[2])
        )
    }
}