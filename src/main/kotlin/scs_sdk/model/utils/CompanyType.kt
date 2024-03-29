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
 * Class that hold companies information
 *
 * @author Felipe Gonzalez
 *
 * @property id - company
 * @property name - company
 */
sealed class CompanyType(val id: String, val name: String) {

    /**
     * Class for source company source during job execution
     */
    class CompanySource(id: String, name: String) : CompanyType(id, name)

    /**
     * Class for destination company during job execution
     */
    class CompanyDestination(id: String, name: String) : CompanyType(id, name)
}