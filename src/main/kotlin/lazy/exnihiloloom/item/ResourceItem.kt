package lazy.exnihiloloom.item

import lazy.exnihiloloom.block.InfestingLeaveBlock
import lazy.exnihiloloom.util.Ref
import net.minecraft.block.LeavesBlock
import net.minecraft.item.Item
import net.minecraft.item.ItemUsageContext
import net.minecraft.util.ActionResult

open class ResourceItem(private val resourceName: String) : Item(Settings().group(Ref.ITEM_GROUP)) {

    override fun useOnBlock(context: ItemUsageContext): ActionResult {
        if (!context.world.isClient && context.stack.item is ResourceItem) {
            val resItem = context.stack.item as ResourceItem
            val blockState = context.world.getBlockState(context.blockPos)
            if (resItem.resourceName == "silkworm" && blockState.block is LeavesBlock) {
                context.stack.decrement(1)
                InfestingLeaveBlock.initiateInfestation(context.world, context.blockPos)
                return ActionResult.SUCCESS
            }
        }
        return ActionResult.PASS
    }
}