package lazy.exnihiloloom.common.tiles

import lazy.exnihiloloom.common.block.InfestingLeavesBlock
import lazy.exnihiloloom.common.config.ModConfig
import lazy.exnihiloloom.common.init.ModTiles
import net.minecraft.block.entity.BlockEntity
import net.minecraft.util.Tickable

class InfestedLeavesTileEntity : BlockEntity(ModTiles.INFESTED_LEAVES), Tickable {

    private var progressWaitInterval = 0

    override fun tick() {
        world?.run {
            if (!isClient) {
                progressWaitInterval++
                if (progressWaitInterval >= ModConfig.TICKS_BETWEEN_SPREAD_ATTEMPT.get()) {
                    progressWaitInterval = 0
                    InfestingLeavesBlock.spread(this, pos)
                }
            }
        }
    }
}