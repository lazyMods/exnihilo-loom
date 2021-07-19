package lazy.exnihiloloom.common.util

import net.minecraft.block.AbstractBlock
import net.minecraft.block.Material
import net.minecraft.sound.BlockSoundGroup

object BlockSettings {

    val INFESTED_LEAVES_SETTINGS = AbstractBlock.Settings.of(Material.LEAVES)
        .strength(.2f)
        .sounds(BlockSoundGroup.GRASS)
        .nonOpaque()
        .suffocates(BlockUtils::neverBlockContext)
        .blockVision(BlockUtils::neverBlockContext)
        .invalidSpawn()
}