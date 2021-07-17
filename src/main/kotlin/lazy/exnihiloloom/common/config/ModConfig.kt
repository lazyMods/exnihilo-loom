package lazy.exnihiloloom.common.config

import ConfigEntry
import net.fabricmc.loader.api.FabricLoader

object ModConfig {

    lateinit var SPREAD_CHANGE: ConfigEntry

    fun init() {
        SPREAD_CHANGE = ConfigParser.load(FabricLoader.getInstance().configDir.resolve("test.props")).first { it.key == "test" }
    }
}