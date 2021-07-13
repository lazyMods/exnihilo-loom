package lazy.exnihiloloom.util

import net.minecraft.block.AbstractBlock
import net.minecraft.sound.BlockSoundGroup

fun AbstractBlock.Settings.with(strength: Float = 1f, sound: BlockSoundGroup = BlockSoundGroup.STONE, noOcclusion: Boolean = false): AbstractBlock.Settings {
    this.strength(strength)
    this.sounds(sound)
    if (noOcclusion) this.nonOpaque()
    return this
}

fun AbstractBlock.Settings.invalidSpawn(): AbstractBlock.Settings {
    this.allowsSpawning(BlockUtils::neverSpawn)
    return this
}