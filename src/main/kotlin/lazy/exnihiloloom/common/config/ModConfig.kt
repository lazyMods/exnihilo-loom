package lazy.exnihiloloom.common.config

import lazy.kconfig.KConfig

object ModConfig {

    val SPREAD_CHANGE = KConfig.createConfigHolder<Double>("spreadChance")
    val TICKS_BETWEEN_SPREAD_ATTEMPT = KConfig.createConfigHolder<Int>("ticksBetweenSpreadAttempt")
    val SECONDS_TO_TRANSFORM_LEAVES = KConfig.createConfigHolder<Int>("secondsToTransformLeaves")
}