package lazy.exnihiloloom.client

import lazy.exnihiloloom.common.init.ModBlocks
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.minecraft.client.render.RenderLayer

object ExNihiloLoomClient : ClientModInitializer {
    override fun onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.INFESTED_LEAVE, ModBlocks.INFESTING_LEAVE)
    }
}