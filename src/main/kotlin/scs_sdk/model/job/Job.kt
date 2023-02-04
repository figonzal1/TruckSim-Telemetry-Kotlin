package scs_sdk.model.job

/**
 *
 * @author Felipe Gonzalez
 */
data class Job(
    val source: JobLocation,
    val destination: JobLocation,
    val plannedDistance: Int,
    val cargo: JobCargo,
    val isSpecial: Boolean,
    val market: String,
    val income: Long,
    //TODO: Check this
    val expectedDeliveryTimestamp: Int
)
