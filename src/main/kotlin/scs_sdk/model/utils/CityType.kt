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


package scs_sdk.model.utils

/**
 * Class that represent different cities types
 *
 * @author Felipe Gonzalez
 * @property id - city
 * @property name - city name
 */
sealed class CityType(val id: String, val name: String) {

    /**
     * Class for source city during job execution
     */
    class CitySource(id: String, name: String) : CityType(id, name)

    /**
     * Class for destination city during job execution
     */
    class CityDestination(id: String, name: String) : CityType(id, name)
}