package lazy.exnihiloloom.common.init

import lazy.exnihiloloom.common.tiles.InfestedLeavesTileEntity
import lazy.exnihiloloom.common.tiles.InfestingLeavesTileEntity
import lazy.exnihiloloom.common.util.Ref
import net.minecraft.block.Block
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import java.util.function.Supplier

object ModTiles {

    var INFESTED_LEAVES: BlockEntityType<InfestedLeavesTileEntity>? = null
    var INFESTING_LEAVES: BlockEntityType<InfestingLeavesTileEntity>? = null

    fun init() {
        INFESTED_LEAVES = register("infested_leaves", ModBlocks.INFESTED_LEAVE) { InfestedLeavesTileEntity() }
        INFESTING_LEAVES = register("infesting_leaves", ModBlocks.INFESTING_LEAVE) { InfestingLeavesTileEntity() }
    }

    private fun <T> register(regName: String, block: Block, tileSupplier: Supplier<T>): BlockEntityType<T> where T : BlockEntity {
        return Registry.register(Registry.BLOCK_ENTITY_TYPE, Identifier(Ref.MOD_ID, regName), BlockEntityType.Builder.create(tileSupplier, block).build(null))
    }
}