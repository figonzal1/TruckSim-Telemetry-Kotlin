package scs_sdk.model.truck.liquids

import scs_sdk.model.truck.liquids.LiquidsType.AdBlue
import scs_sdk.model.truck.liquids.LiquidsType.Fuel

data class Liquids(
    val fuel: Fuel,
    val adBlue: AdBlue
)



