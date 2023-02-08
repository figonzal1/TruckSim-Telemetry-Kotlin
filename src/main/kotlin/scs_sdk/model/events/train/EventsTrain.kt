/*
 * This file is subject to the terms and conditions defined in file 'LICENSE', which is part of this source code package
 *
 *  Author: Felipe González Alarcón
 *  Email: felipe.gonzalezalarcon94@gmail.com
 *
 *  Project: ETS2-Telemetry
 *  Module: ETS2-Telemetry.main
 *  Last modified: 08-02-23 17:49
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

package scs_sdk.model.events.train

import scs_sdk.model.utils.CityType.CityDestination
import scs_sdk.model.utils.CityType.CitySource

/**
 * Class that hold events information related with train
 *
 * @author Felipe Gonzalez
 * @property source city
 * @property destination city
 * @property amount of ticket
 * @property isActive [True|False] if event is still active
 */
data class EventsTrain(
    val source: CitySource,
    val destination: CityDestination,
    val amount: Long,
    val isActive: Boolean
)
