package lazy.exnihiloloom.init

import lazy.exnihiloloom.util.Ref
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

    fun init() {
        register("dust", DUST)
    }

    private fun register(regName: String, block: Block, group: ItemGroup = ItemGroup.MISC) {
        Registry.register(Registry.BLOCK, Identifier(Ref.MOD_ID, regName), block)
        Registry.register(Registry.ITEM, Identifier(Ref.MOD_ID, regName), BlockItem(block, Item.Settings().group(group)))
    }
}