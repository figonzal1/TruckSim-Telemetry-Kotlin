/*
 * This file is subject to the terms and conditions defined in file 'LICENSE', which is part of this source code package
 *
 *  Author: Felipe González Alarcón
 *  Email: felipe.gonzalezalarcon94@gmail.com
 *
 *  Project: TruckSim-Telemetry-Kotlin
 *  Module: TruckSim-Telemetry-Kotlin.main
 *  Last modified: 09-02-23 01:02
 */


package scs_sdk.model.game

/**
 * Enum class for game types
 *
 * @property UNKNOWN
 * @property ETS2
 * @property ATS
 */
enum class GameType {

    /**
     * If case unknown game
     */
    UNKNOWN,

    /**
     * For euro truck sim 2 game
     */
    ETS2,

    /**
     * For american truck sim game
     */
    ATS
}

