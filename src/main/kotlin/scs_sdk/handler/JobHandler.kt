/*
 * This file is subject to the terms and conditions defined in file 'LICENSE', which is part of this source code package
 *
 *  Author: Felipe González Alarcón
 *  Email: felipe.gonzalezalarcon94@gmail.com
 *
 *  Project: ETS2-Telemetry
 *  Module: ETS2-Telemetry.main
 *  Last modified: 08-02-23 16:27
 */

/*
 * This file is subject to the terms and conditions defined in file 'LICENSE', which is part of this source code package
 *
 *  Author: Felipe González Alarcón
 *  Email: felipe.gonzalezalarcon94@gmail.com
 *
 *  Project: ETS2-Telemetry
 *  Module: ETS2-Telemetry.main
 *  Last modified: 08-02-23 12:19
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

package scs_sdk.handler

import scs_sdk.model.job.Job
import scs_sdk.model.job.JobCargo
import scs_sdk.model.job.JobLocation
import scs_sdk.model.utils.CityType.CityDestination
import scs_sdk.model.utils.CityType.CitySource
import scs_sdk.model.utils.CompanyType.CompanyDestination
import scs_sdk.model.utils.CompanyType.CompanySource
import utils.*

/**
 * Parse [ByteArray] with job data and transform to [Job]
 *
 * @author Felipe Gonzalez
 * @param rawData - byte array of job data
 *
 * @return [Job] object
 */
fun job(rawData: ByteArray) = with(rawData) {
    Job(
        source = JobLocation(
            jobCity = CitySource(getString(2940), getString(3004)),
            jobCompany = CompanySource(getString(3068), getString(3132))
        ),
        destination = JobLocation(
            jobCity = CityDestination(getString(2684), getString(2748)),
            jobCompany = CompanyDestination(getString(2812), getString(2876))
        ),
        cargo = JobCargo(
            id = getString(2556),
            name = getString(2620),
            mass = getFloat(748),
            unitMass = getFloat(944),
            damage = getFloat(1456),
            isLoaded = getBool(1564)
        ),
        expectedDeliveryTimestamp = getUInt(88).toInt(),
        plannedDistance = getUInt(100).toInt(),
        income = getULong(4000).toLong(),
        market = getString(3404, 32),
        isSpecial = getBool(1565)
    )
}