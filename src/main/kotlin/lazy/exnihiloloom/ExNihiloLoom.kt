package lazy.exnihiloloom

import lazy.exnihiloloom.common.config.ModConfig
import lazy.exnihiloloom.common.init.ModBlocks
import lazy.exnihiloloom.common.init.ModItems
import lazy.exnihiloloom.common.init.ModTiles
import net.fabricmc.api.ModInitializer

@Suppress("unused")
object ExNihiloLoom : ModInitializer {

    override fun onInitialize() {
        ModBlocks.init()
        ModTiles.init()
        ModItems.init()
        ModConfig.init()
    }
}