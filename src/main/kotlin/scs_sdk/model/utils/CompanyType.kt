/*
 * This file is subject to the terms and conditions defined in file 'LICENSE', which is part of this source code package
 *
 *  Author: Felipe González Alarcón
 *  Email: felipe.gonzalezalarcon94@gmail.com
 *
 *  Project: ETS2-Telemetry
 *  Module: ETS2-Telemetry.main
 *  Last modified: 08-02-23 17:31
 */



package scs_sdk.model.utils

/**
 * Class that hold companies information
 *
 * @author Felipe Gonzalez
 *
 * @property id - company
 * @property name - company
 */
sealed class CompanyType(val id: String, val name: String) {
    class CompanySource(id: String, name: String) : CompanyType(id, name)
    class CompanyDestination(id: String, name: String) : CompanyType(id, name)
}