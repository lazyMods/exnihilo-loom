package lazy.exnihiloloom.common.util

import net.minecraft.block.BlockState
import net.minecraft.entity.EntityType
import net.minecraft.util.math.BlockPos
import net.minecraft.world.BlockView


object BlockUtils {

    fun neverSpawn(state: BlockState, view: BlockView, pos: BlockPos, entityType: EntityType<*>): Boolean {
        return false
    }

    fun neverBlockContext(state: BlockState, view: BlockView, pos: BlockPos): Boolean {
        return false
    }
}