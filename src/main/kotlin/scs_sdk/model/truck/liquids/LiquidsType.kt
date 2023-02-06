package scs_sdk.model.truck.liquids

sealed class LiquidsType {

    data class Fuel(
        val capacity: Float,
        val warning: LiquidsWarning,
        val value: Float,
        val avgConsumption: Float,
        val range: Float
    ) : LiquidsType()

    data class AdBlue(
        val capacity: Float,
        val warning: LiquidsWarning,
        val value: Float
    ) : LiquidsType()
}
