package scs_sdk

import com.sun.jna.Pointer
import jna.Ets2Kernel32Impl
import mu.KotlinLogging
import utils.*
import utils.exceptions.ReadMemoryException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

var offset = 0

class ScsShareMemory(
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

    suspend fun parseBytes(function: suspend (Boolean) -> Unit) {

        //First byte section
        val sdkActive = rawData.getBool(0)
        function(sdkActive)
        //logger.debug { "sdkActive: $sdkActive" }

        val isPaused = rawData.getBool(4)
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
        logger.debug { "Job delivered started timestamp: ${rawData.getUInt(444)}" }
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
        logger.debug { "Game scale: ${rawData.getFloat(700)}" }
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

        logger.debug { "Truck speed : ${rawData.getSpeedFloat(752)}km/h" }
        logger.debug { "Truck rpm value : ${rawData.getFloat(756)}" }

        //Controls
        logger.debug { "Controls input steering: ${rawData.getFloat(760)}" }
        logger.debug { "Controls input throttle: ${rawData.getFloat(764)}" }
        logger.debug { "Controls input brake: ${rawData.getFloat(768)}" }
        logger.debug { "Controls input clutch: ${rawData.getSpeedFloat(772)}" }

        logger.debug { "Controls game steering: ${rawData.getFloat(776)}" }
        logger.debug { "Controls game throttle: ${rawData.getFloat(780)}" }
        logger.debug { "Controls game brake: ${rawData.getFloat(784)}" }
        logger.debug { "Controls game clutch: ${rawData.getFloat(788)}" }

        logger.debug { "Cruise control: ${rawData.getSpeedFloat(792)}" }

        logger.debug { "Truck brake air pressure value: ${rawData.getFloat(796)}" }
        logger.debug { "Truck brake temperature value: ${rawData.getFloat(800)}" }

        logger.debug { "Truck fuel value: ${rawData.getFloat(804)}" }
        logger.debug { "Truck fuel avg consumption: ${rawData.getFloat(808)}" }
        logger.debug { "Truck fuel range: ${rawData.getFloat(812)}" }
        logger.debug { "Truck ad-blue value: ${rawData.getFloat(816)}" }

        logger.debug { "Truck engine oil pressure value: ${rawData.getFloat(820)}" }
        logger.debug { "Truck engine oil temperature value: ${rawData.getFloat(824)}" }
        logger.debug { "Truck engine water temperature value: ${rawData.getFloat(828)}" }
        logger.debug { "Truck engine battery voltage value: ${rawData.getFloat(832)}" }

        //Lights
        logger.debug { "Truck light dashboard backlight: ${rawData.getFloat(836)}" }

        //Damage
        logger.debug { "Truck engine damage: ${rawData.getFloat(840)}" }
        logger.debug { "Truck transmission damage: ${rawData.getFloat(844)}" }
        logger.debug { "Truck cabin damage: ${rawData.getFloat(848)}" }
        logger.debug { "Truck chassis damage: ${rawData.getFloat(852)}" }
        logger.debug { "Truck wheel damage: ${rawData.getFloat(856)}" }

        logger.debug { "Truck odometer: ${rawData.getFloat(860)}" }

        logger.debug { "Navigation distance: ${rawData.getFloat(864)}" }
        logger.debug { "Navigation time: ${rawData.getFloat(868)}" }
        logger.debug { "Navigation speed limit: ${rawData.getSpeedFloat(872)}" }

        logger.debug { "Truck wheels suspension deflection ${rawData.getFloat(876)}" }
        logger.debug { "Truck wheels velocity: ${rawData.getFloat(880)}" }
        logger.debug { "Truck wheels steering: ${rawData.getFloat(884)}" }
        logger.debug { "Truck wheels rotation: ${rawData.getFloat(888)}" }
        logger.debug { "Truck wheels lift: ${rawData.getFloat(892)}" }
        logger.debug { "Truck wheels lift offset: ${rawData.getFloat(896)}" }

        logger.debug { "Event job delivered cargo damage: ${rawData.getFloat(900)}" }
        logger.debug { "Event job delivered distance: ${rawData.getUInt(904)}" }
        logger.debug { "Event refuel paid amount: ${rawData.getFloat(908)}" }

        logger.debug { "Job cargo damage: ${rawData.getFloat(912)}" }

        //5th section
        logger.debug { "Truck wheels steerable: ${rawData.getBool(1500)}" }
        logger.debug { "Truck wheels simulated: ${rawData.getBool(1504)}" }
        logger.debug { "Truck wheels powered: ${rawData.getBool(1508)}" }
        logger.debug { "Truck wheels liftable: ${rawData.getBool(1512)}" }

        logger.debug { "Job cargo isLoaded: ${rawData.getBool(1516)}" }
        logger.debug { "Job is special: ${rawData.getBool(1520)}" }

        logger.debug { "Truck brakes parking enable: ${rawData.getBool(1524)}" }
        logger.debug { "Truck brakes motor enabled: ${rawData.getBool(1528)}" }
        logger.debug { "Truck brakes airPressure warning enabled: ${rawData.getBool(1532)}" }
        logger.debug { "Truck brakes airPressure emergency enabled: ${rawData.getBool(1536)}" }
        logger.debug { "Truck fuel warning enabled: ${rawData.getBool(1540)}" }
        logger.debug { "Truck adblue warning enabled: ${rawData.getBool(1544)}" }
        logger.debug { "Truck engine oilPressure warning enabled: ${rawData.getBool(1548)}" }
        logger.debug { "Truck engine water temp warning enabled: ${rawData.getBool(1552)}" }
        logger.debug { "Truck engine battery warning enabled: ${rawData.getBool(1556)}" }
        logger.debug { "Truck electric enabled: ${rawData.getBool(1560)}" }
        logger.debug { "Truck engine enabled: ${rawData.getBool(1564)}" }
        logger.debug { "Truck wipers enabled: ${rawData.getBool(1568)}" }

        //Lights
        logger.debug { "Truck lights blinker left enabled: ${rawData.getBool(1572)}" }
        logger.debug { "Truck lights blinker right enabled: ${rawData.getBool(1576)}" }
        logger.debug { "Truck lights blinker left active: ${rawData.getBool(1580)}" }
        logger.debug { "Truck lights blinker right active: ${rawData.getBool(1584)}" }
        logger.debug { "Truck lights parking enabled: ${rawData.getBool(1588)}" }
        logger.debug { "Truck lights beamLow enabled: ${rawData.getBool(1592)}" }
        logger.debug { "Truck lights beamHigh enabled: ${rawData.getBool(1596)}" }
        logger.debug { "Truck lights beacon enabled: ${rawData.getBool(1600)}" }
        logger.debug { "Truck lights brake enabled: ${rawData.getBool(1604)}" }
        logger.debug { "Truck lights reverse enabled: ${rawData.getBool(1608)}" }
        logger.debug { "Truck lights hazard enabled: ${rawData.getBool(1612)}" }

        logger.debug { "Truck cruise control enabled: ${rawData.getBool(1616)}" }
        logger.debug { "Truck wheels on ground: ${rawData.getBool(1620)}" }

        logger.debug { "Truck transmission selector: ${rawData.getBool(1624)}" }
        logger.debug { "Truck differential lock enabled: ${rawData.getBool(1628)}" }
        logger.debug { "Truck liftAxle enabled: ${rawData.getBool(1632)}" }
        logger.debug { "Truck liftAxle indicator enabled: ${rawData.getBool(1636)}" }
        logger.debug { "Trailer liftAxle enabled: ${rawData.getBool(1640)}" }
        logger.debug { "Trailer liftAxle indicator enabled: ${rawData.getBool(1644)}" }

        logger.debug { "Events job delivered auto-parked: ${rawData.getBool(1648)}" }
        logger.debug { "Events job started autoloader: ${rawData.getBool(1652)}" }

        //6th section

    }

}
