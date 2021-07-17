package lazy.exnihiloloom.common.util

import net.minecraft.block.AbstractBlock

fun AbstractBlock.Settings.invalidSpawn(): AbstractBlock.Settings {
    this.allowsSpawning(BlockUtils::neverSpawn)
    return this
}