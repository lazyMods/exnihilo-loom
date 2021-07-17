package lazy.exnihiloloom.common.tiles

import lazy.exnihiloloom.common.block.InfestingLeaveBlock
import lazy.exnihiloloom.common.init.ModTiles
import net.minecraft.block.entity.BlockEntity
import net.minecraft.nbt.CompoundTag
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket
import net.minecraft.util.Tickable

class InfestingLeavesTileEntity : BlockEntity(ModTiles.INFESTING_LEAVES), Tickable {

    private val tagProgress = "progress"

    private var progress = 0

    //TODO: Config secToTransform
    private var progressInterval = (10 * 20) / 100
    private var spreadCounter = 0

    override fun tick() {
        world?.run {
            if (!isClient) {
                progressInterval--
                if (progressInterval <= 0) {
                    progress++
                    spreadCounter++

                    if (progress >= 100)
                        InfestingLeaveBlock.finishInfestation(this, pos)

                    //TODO: Config tickBetweenAttempt
                    if (spreadCounter >= 100) {
                        InfestingLeaveBlock.spread(this, pos)
                        spreadCounter = 0
                    }

                    //TODO: 14
                    progressInterval = (10 * 20) / 100
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
