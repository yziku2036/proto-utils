package hmjn023.protoutils.common.item

import hmjn023.protoutils.ProtoUtils
import net.minecraft.nbt.Tag
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.InteractionResultHolder
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.context.UseOnContext
import net.minecraft.world.level.ClipContext
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.state.BlockState

class LightningStaff(properties: Properties?) : Item(properties) {
    override fun isFoil(stack: ItemStack): Boolean {
        val nbt = stack.getOrCreateTag()
        return (nbt.contains(ProtoUtils.MOD_ID, Tag.TAG_COMPOUND.toInt())
                && nbt.getCompound(ProtoUtils.MOD_ID).contains("UseCount", Tag.TAG_COMPOUND.toInt()))
    }

    override fun use(level: Level, player: Player, hand: InteractionHand?): InteractionResultHolder<ItemStack> {
        val stack = player.getItemInHand(hand)
        val result = getPlayerPOVHitResult(level, player, ClipContext.Fluid.ANY)
        val state: BlockState = level.getBlockState(result.blockPos)
        if (state.isAir)
            return InteractionResultHolder.fail(stack)
        return InteractionResultHolder.success(stack)
    }

    override fun useOn(context: UseOnContext): InteractionResult {
        val player = context.player
        val level = player!!.level
        val pos = context.clickedPos
        val state = level.getBlockState(pos)
        if (state.isAir)
            return InteractionResult.FAIL

        val bolt = EntityType.LIGHTNING_BOLT.create(level)
        level.addFreshEntity(bolt);
        println("Used Lightning Staff!")
        player.addEffect(MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1200, 3))
        //val text=TextComponent("hoge");
        //player.server!!.sendMessage(ComponentUtils.DEFAULT_NO_STYLE_SEPARATOR,player.uuid)
        return InteractionResult.SUCCESS
    }
}