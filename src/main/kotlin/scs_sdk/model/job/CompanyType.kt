package scs_sdk.model.job

sealed class CompanyType(
    val id: String,
    val name: String
) {
    class CompanySource(id: String, name: String) : CompanyType(id, name)
    class CompanyDestination(id: String, name: String) : CompanyType(id, name)
}