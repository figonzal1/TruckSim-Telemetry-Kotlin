# TruckSim-Telemetry-Kotlin

[![CodeFactor](https://www.codefactor.io/repository/github/figonzal1/trucksim-telemetry-kotlin/badge)](https://www.codefactor.io/repository/github/figonzal1/trucksim-telemetry-kotlin)
![GitHub repo size](https://img.shields.io/github/repo-size/figonzal1/TruckSim-Telemetry-Kotlin)
![GitHub](https://img.shields.io/github/license/figonzal1/TruckSim-Telemetry-Kotlin)
[![](https://jitpack.io/v/figonzal1/TruckSim-Telemetry-Kotlin.svg)](https://jitpack.io/#figonzal1/TruckSim-Telemetry-Kotlin)

TruckSim-Telemetry-Kotlin is a library built in kotlin using flows and coroutines that takes telemetry data for Euro
Truck Simulator 2 and American Truck Simulator provided by
the [scs-sdk-plugin](https://github.com/RenCloud/scs-sdk-plugin) and outputs parsed data and events.

This Kotlin module is based on and inspired by the Js
library [TruckSim-Telemetry](https://github.com/kniffen/TruckSim-Telemetry) by [kniffen](https://github.com/kniffen)

## Documentation

See in https://figonzal1.github.io/TruckSim-Telemetry-Kotlin/

## Getting started

### Prerequisites

#### Download and install the 󠀠󠀠󠀠󠀠[scs-sdk-plugin](https://github.com/RenCloud/scs-sdk-plugin) by [RenCloud](https://github.com/RenCloud)

Supported plugin versions

:white_check_mark: v1.12.0

#### Install the 󠀠󠀠󠀠󠀠[windows-build-tools](https://github.com/felixrieseberg/windows-build-tools)

### Installing

- Add it in your root build.gradle at the end of repositories:

````groovy
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
````

- Add the dependency

````groovy
dependencies {
    implementation 'com.github.figonzal1:TruckSim-Telemetry-Kotlin:1.0'
}
````

## How to use it

Example from [Main.kt](https://github.com/figonzal1/TruckSim-Telemetry-Kotlin/blob/master/src/main/kotlin/Main.kt)

- Instantiate ``ScsTelemetry`` class

```kotlin
coroutineScope {
    val telemetry = ScsTelemetry()
}
```

- Start observing changes (inside of ``coroutineScope``)

```kotlin
//Listen changes every delayTime. Default: 1000ms
...
launch {
    telemetry.watch(delayTime = 2000L)
}
... 
```

- Consume data flow (inside of ``coroutineScope``)

```kotlin
...
launch {
    //Collect only one value
    telemetry.telemetryFlow.first {
        println("Telemetry data: $it")
        true
    }

    //Collect infinite values
    telemetry.telemetryFlow.collect {
        println("Telemetry data: $it")
    }
}
...
```

Telemetry flow
return [TelemetryData](https://figonzal1.github.io/TruckSim-Telemetry-Kotlin/-truck-sim--telemetry--kotlin/scs_sdk.model/-telemetry-data/index.html)
data class

## License

This project is licensed under the MIT License - see the LICENSE file for details