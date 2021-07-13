package lazy.exnihiloloom.block

import lazy.exnihiloloom.init.ModBlocks
import lazy.exnihiloloom.util.BlockSettings
import lazy.exnihiloloom.util.BlockUtils
import net.minecraft.block.Block
import net.minecraft.block.LeavesBlock
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World


//TODO: ITOPProvider
class InfestingLeaveBlock : Block(BlockSettings.INFESTED_LEAVES_SETTINGS) {

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
                    //TODO: Spread Change
                    //if (random.nextDouble() <= Config.getSpreadChance()) {
                    initiateInfestation(world, it)
                    //}
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
}


