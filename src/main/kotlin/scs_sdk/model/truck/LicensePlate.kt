package scs_sdk.model.truck

import scs_sdk.model.utils.GenericResource

data class LicensePlate(
    val value: String,
    val country: GenericResource
)
