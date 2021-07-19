package lazy.exnihiloloom

import lazy.exnihiloloom.common.init.ModBlocks
import lazy.exnihiloloom.common.init.ModItems
import lazy.exnihiloloom.common.init.ModTiles
import lazy.kconfig.KConfig
import net.fabricmc.api.ModInitializer
import net.fabricmc.loader.api.FabricLoader

@Suppress("unused")
object ExNihiloLoom : ModInitializer {

    override fun onInitialize() {
        ModBlocks.init()
        ModTiles.init()
        ModItems.init()
        KConfig.init(FabricLoader.getInstance().configDir.resolve("exnihiloloom.toml"))
    }
}