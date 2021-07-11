package lazy.exnihiloloom.init

import lazy.exnihiloloom.item.ResourceItem
import lazy.exnihiloloom.util.Ref
import net.minecraft.item.FoodComponent
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry


object ModItems {

    val SILKWORM = ResourceItem("silkworm")
    val COOKED_SILKWORM = Item(
        Item.Settings().group(ItemGroup.MISC).food(FoodComponent.Builder().hunger(2).saturationModifier(.6f).build())
    )

    fun init() {
        register("silkworm", SILKWORM)
        register("cooked_silkworm", COOKED_SILKWORM)
    }

    private fun register(regName: String, item: Item) {
        Registry.register(Registry.ITEM, Identifier(Ref.MOD_ID, regName), item)
    }
}