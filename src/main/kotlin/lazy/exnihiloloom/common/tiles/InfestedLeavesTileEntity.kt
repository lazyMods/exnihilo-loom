package lazy.exnihiloloom.common.tiles

import lazy.exnihiloloom.common.block.InfestingLeaveBlock
import lazy.exnihiloloom.common.init.ModTiles
import net.minecraft.block.entity.BlockEntity
import net.minecraft.util.Tickable

class InfestedLeavesTileEntity : BlockEntity(ModTiles.INFESTED_LEAVES), Tickable {

    private var progress = 0

    override fun tick() {
        world?.run {
            if (!isClient) {
                progress++
                //TODO: Spread time instead of random
                if (random.nextInt() > .5f){
                    progress = 0
                    InfestingLeaveBlock.spread(this, pos)
                }
            }
        }
    }
}