package hmjn023.protoutils.common.item

import hmjn023.protoutils.ProtoUtils
import net.minecraft.core.BlockPos
import net.minecraft.nbt.Tag
import net.minecraft.nbt.NbtUtils
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.InteractionResultHolder
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.context.BlockPlaceContext
import net.minecraft.world.item.context.UseOnContext
import net.minecraft.world.level.ClipContext
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.nbt.CompoundTag;
    class TestItem(properties: Properties?) : Item(properties) {

    }