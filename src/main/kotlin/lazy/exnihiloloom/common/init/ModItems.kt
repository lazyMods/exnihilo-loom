package lazy.exnihiloloom.common.init

import lazy.exnihiloloom.common.item.ResourceItem
import lazy.exnihiloloom.common.util.Ref
import net.minecraft.item.FoodComponent
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry


object ModItems {

    val SILKWORM = ResourceItem("silkworm")
    val COOKED_SILKWORM = Item(
        Item.Settings().group(Ref.ITEM_GROUP).food(FoodComponent.Builder().hunger(2).saturationModifier(.6f).build())
    )

    fun init() {
        register("silkworm", SILKWORM)
        register("cooked_silkworm", COOKED_SILKWORM)
    }

    private fun register(regName: String, item: Item) {
        Registry.register(Registry.ITEM, Identifier(Ref.MOD_ID, regName), item)
    }
}