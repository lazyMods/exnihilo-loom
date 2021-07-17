package lazy.exnihiloloom.common.block

import lazy.exnihiloloom.common.init.ModTiles
import lazy.exnihiloloom.common.util.BlockSettings
import net.minecraft.block.Block
import net.minecraft.block.BlockEntityProvider
import net.minecraft.block.entity.BlockEntity
import net.minecraft.world.BlockView

//TODO: Equivalent of IForgeShearable
class InfestedLeaveBlock : Block(BlockSettings.INFESTED_LEAVES_SETTINGS), BlockEntityProvider {

    override fun createBlockEntity(world: BlockView?): BlockEntity? {
        return ModTiles.INFESTED_LEAVES?.instantiate()
    }
}