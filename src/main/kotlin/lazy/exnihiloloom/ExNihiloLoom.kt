package lazy.exnihiloloom

import lazy.exnihiloloom.init.ModBlocks
import net.fabricmc.api.ModInitializer

@Suppress("unused")
object ExNihiloLoom : ModInitializer {

    override fun onInitialize() {
        ModBlocks.init()
    }
}