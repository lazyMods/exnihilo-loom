package lazy.exnihiloloom.common.config

import lazy.kconfig.ConfigHolder
import lazy.kconfig.KConfig
import net.fabricmc.loader.api.FabricLoader

object ModConfig {

    lateinit var SPREAD_CHANCE: ConfigHolder<Double>
    lateinit var TICKS_BETWEEN_SPREAD_ATTEMPT: ConfigHolder<Int>
    lateinit var SECONDS_TO_TRANSFORM_LEAVES: ConfigHolder<Int>

    fun init() {
        val kBuilder = KConfig.createBuilder(FabricLoader.getInstance().configDir.resolve("exnihiloloom.toml"))
        SPREAD_CHANCE = kBuilder.defineDoubleRange("spreadChance", 0.3, 0.001, 1.0)
        TICKS_BETWEEN_SPREAD_ATTEMPT = kBuilder.defineIntRange("ticksBetweenSpreadAttempt", 100, 1)
        SECONDS_TO_TRANSFORM_LEAVES = kBuilder.defineIntRange("secondsToTransformLeaves", 10, 1)
        kBuilder.build()
    }

}