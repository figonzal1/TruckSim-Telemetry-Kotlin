package scs_sdk.model.job

sealed class CityType(
    val id: String,
    val name: String
) {
    class CitySource(id: String, name: String) : CityType(id, name)
    class CityDestination(id: String, name: String) : CityType(id, name)
}