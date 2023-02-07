package scs_sdk.model.job

import scs_sdk.model.utils.CityType
import scs_sdk.model.utils.CompanyType

data class JobLocation(
    val jobCity: CityType,
    val jobCompany: CompanyType
)