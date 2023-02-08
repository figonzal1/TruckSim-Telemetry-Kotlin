/*
 * This file is subject to the terms and conditions defined in file 'LICENSE', which is part of this source code package
 *
 *  Author: Felipe González Alarcón
 *  Email: felipe.gonzalezalarcon94@gmail.com
 *
 *  Project: ETS2-Telemetry
 *  Module: ETS2-Telemetry.main
 *  Last modified: 08-02-23 17:31
 */

/*
 * This file is subject to the terms and conditions defined in file 'LICENSE', which is part of this source code package
 *
 *  Author: Felipe González Alarcón
 *  Email: felipe.gonzalezalarcon94@gmail.com
 *
 *  Project: ETS2-Telemetry
 *  Module: ETS2-Telemetry.main
 *  Last modified: 08-02-23 12:18
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
    class CitySource(id: String, name: String) : CityType(id, name)
    class CityDestination(id: String, name: String) : CityType(id, name)
}