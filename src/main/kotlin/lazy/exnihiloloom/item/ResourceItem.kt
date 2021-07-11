package lazy.exnihiloloom.item

import net.minecraft.block.LeavesBlock
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemUsageContext
import net.minecraft.util.ActionResult

//TODO: Change the group to ExNihiloLoom
open class ResourceItem(private val resourceName: String) : Item(Settings().group(ItemGroup.MISC)){

    override fun useOnBlock(context: ItemUsageContext): ActionResult {
        if(!context.world.isClient && context.stack.item is ResourceItem){
            val resItem = context.stack.item as ResourceItem
            val blockState = context.world.getBlockState(context.blockPos)
            if (resItem.resourceName == "silkworm" && blockState.block is LeavesBlock){
                context.stack.decrement(1)
                //TODO: Infest
                return ActionResult.SUCCESS
            }
        }
        return ActionResult.PASS
    }
}