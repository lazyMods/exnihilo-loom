package lazy.exnihiloloom

import lazy.exnihiloloom.init.ModBlocks
import lazy.exnihiloloom.init.ModItems
import net.fabricmc.api.ModInitializer

@Suppress("unused")
object ExNihiloLoom : ModInitializer {

    override fun onInitialize() {
        ModBlocks.init()
        ModItems.init()
    }
}