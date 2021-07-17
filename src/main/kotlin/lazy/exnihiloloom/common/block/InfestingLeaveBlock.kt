package lazy.exnihiloloom.common.block

import lazy.exnihiloloom.common.config.ModConfig
import lazy.exnihiloloom.common.init.ModBlocks
import lazy.exnihiloloom.common.init.ModTiles
import lazy.exnihiloloom.common.util.BlockSettings
import lazy.exnihiloloom.common.util.Ref
import net.minecraft.block.Block
import net.minecraft.block.BlockEntityProvider
import net.minecraft.block.LeavesBlock
import net.minecraft.block.entity.BlockEntity
import net.minecraft.util.math.BlockPos
import net.minecraft.world.BlockView
import net.minecraft.world.World


//TODO: ITOPProvider
class InfestingLeaveBlock : Block(BlockSettings.INFESTED_LEAVES_SETTINGS), BlockEntityProvider {

    companion object {
        fun finishInfestation(world: World, pos: BlockPos) {
            world.setBlockState(pos, ModBlocks.INFESTED_LEAVE.defaultState)
        }

        fun initiateInfestation(world: World, pos: BlockPos) {
            world.setBlockState(pos, ModBlocks.INFESTING_LEAVE.defaultState)
        }

        fun spread(world: World, pos: BlockPos) {
            if (!world.isClient) {
                val nearbyLeaves: List<BlockPos> = getNearbyLeaves(world, pos)
                nearbyLeaves.forEach {
                    if (world.random.nextDouble() <= ModConfig.SPREAD_CHANGE.getAsDouble()) {
                        initiateInfestation(world, it)
                    }
                }
            }
        }

        private fun getNearbyLeaves(world: World, pos: BlockPos): List<BlockPos> {
            val nearbyLeaves: MutableList<BlockPos> = arrayListOf()
            BlockPos.stream(BlockPos(pos.x - 1, pos.y - 1, pos.z - 1), BlockPos(pos.x + 1, pos.y + 1, pos.z + 1)).forEach {
                if (world.getBlockState(it).block is LeavesBlock) {
                    nearbyLeaves.add(BlockPos(it))
                }
            }
            return nearbyLeaves
        }

    }

    override fun createBlockEntity(world: BlockView?): BlockEntity? {
        return ModTiles.INFESTING_LEAVES?.instantiate()
    }
}


