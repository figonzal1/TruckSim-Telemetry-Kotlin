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


package scs_sdk.model.job

import scs_sdk.model.utils.CityType
import scs_sdk.model.utils.CompanyType

/**
 * Class related to location of jobs
 *
 * @author Felipe Gonzalez
 *
 * @property jobCity
 * @property jobCompany
 */
data class JobLocation(val jobCity: CityType, val jobCompany: CompanyType)