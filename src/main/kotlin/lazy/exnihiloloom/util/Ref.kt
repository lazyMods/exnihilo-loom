package lazy.exnihiloloom.util

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.block.Blocks
import net.minecraft.item.ItemStack
import net.minecraft.util.Identifier


object Ref {
    const val MOD_ID = "exnihiloloom"

    val ITEM_GROUP = FabricItemGroupBuilder.build(Identifier(MOD_ID, "general")) { ItemStack(Blocks.COBBLESTONE) }
}