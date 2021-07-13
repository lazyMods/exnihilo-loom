package lazy.exnihiloloom.util

import net.minecraft.block.AbstractBlock
import net.minecraft.block.Material
import net.minecraft.sound.BlockSoundGroup

object BlockSettings {

    val INFESTED_LEAVES_SETTINGS = AbstractBlock.Settings.of(Material.LEAVES).with(.2f, BlockSoundGroup.GRASS, true).invalidSpawn()
}