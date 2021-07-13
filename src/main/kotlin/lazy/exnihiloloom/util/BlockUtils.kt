package lazy.exnihiloloom.util

import net.minecraft.block.AbstractBlock
import net.minecraft.block.BlockState
import net.minecraft.block.Material
import net.minecraft.entity.EntityType
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.math.BlockPos
import net.minecraft.world.BlockView


object BlockUtils {

    fun neverSpawn(state: BlockState, view: BlockView, pos: BlockPos, entityType: EntityType<*>): Boolean {
        return false
    }
}