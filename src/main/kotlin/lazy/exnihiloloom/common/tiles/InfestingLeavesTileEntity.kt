package lazy.exnihiloloom.common.tiles

import lazy.exnihiloloom.common.block.InfestingLeavesBlock
import lazy.exnihiloloom.common.config.ModConfig
import lazy.exnihiloloom.common.init.ModTiles
import net.minecraft.block.entity.BlockEntity
import net.minecraft.nbt.CompoundTag
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket
import net.minecraft.util.Tickable

class InfestingLeavesTileEntity : BlockEntity(ModTiles.INFESTING_LEAVES), Tickable {

    private val tagProgress = "progress"

    private var progress = 0
    private var progressWaitInterval: Int = ModConfig.SECONDS_TO_TRANSFORM_LEAVES.get() * 20 / 100
    private var spreadCounter = 0

    override fun tick() {
        world?.run {
            if (!isClient) {
                progressWaitInterval--
                if (progressWaitInterval <= 0) {
                    progress++
                    spreadCounter++

                    if (progress >= 100) InfestingLeavesBlock.finishInfestation(this, pos)

                    if (spreadCounter >= ModConfig.TICKS_BETWEEN_SPREAD_ATTEMPT.get()) {
                        InfestingLeavesBlock.spread(this, pos)
                        spreadCounter = 0
                    }
                    progressWaitInterval = ModConfig.SECONDS_TO_TRANSFORM_LEAVES.get() * 20 / 100
                    updateListeners(pos, getBlockState(pos), getBlockState(pos), 2)
                }
            }
        }
    }

    override fun toUpdatePacket(): BlockEntityUpdateS2CPacket {
        val tag = CompoundTag()
        tag.putInt(tagProgress, progress)
        return BlockEntityUpdateS2CPacket(pos, -1, tag)
    }

    //TODO: OnDataPacket is forge specific
}
