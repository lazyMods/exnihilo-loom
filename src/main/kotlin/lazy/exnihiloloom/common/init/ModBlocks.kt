package lazy.exnihiloloom.common.init

import lazy.exnihiloloom.common.block.InfestedLeaveBlock
import lazy.exnihiloloom.common.block.InfestingLeaveBlock
import lazy.exnihiloloom.common.util.Ref
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.FallingBlock
import net.minecraft.block.Material
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object ModBlocks {

    val DUST = FallingBlock(AbstractBlock.Settings.of(Material.AGGREGATE).strength(.7f).sounds(BlockSoundGroup.WOOL))
    val INFESTED_LEAVE = InfestedLeaveBlock()
    val INFESTING_LEAVE = InfestingLeaveBlock()

    fun init() {
        register("dust", DUST)
        register("infested_leaves", INFESTED_LEAVE)
        register("infesting_leaves", INFESTING_LEAVE)
    }

    private fun register(regName: String, block: Block, group: ItemGroup = Ref.ITEM_GROUP, item: Boolean = true) {
        Registry.register(Registry.BLOCK, Identifier(Ref.MOD_ID, regName), block)
        if (item)
            Registry.register(Registry.ITEM, Identifier(Ref.MOD_ID, regName), BlockItem(block, Item.Settings().group(group)))
    }
}