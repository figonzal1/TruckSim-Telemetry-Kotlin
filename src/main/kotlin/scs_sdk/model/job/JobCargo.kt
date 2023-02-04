package scs_sdk.model.job

data class JobCargo(
    val id: String,
    val name: String,
    val mass: Float,
    val unitMass: Float,
    val damage: Float,
    val isLoaded: Boolean,
)
