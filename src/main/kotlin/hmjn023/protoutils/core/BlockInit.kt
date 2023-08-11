package hmjn023.protoutils.core

import hmjn023.protoutils.ProtoUtils
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.material.Material
import net.minecraft.world.level.material.MaterialColor
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries


class BlockInit {
    public var blockDeferredRegister: DeferredRegister<Block> = DeferredRegister.create(
        ForgeRegistries.BLOCKS,
        ProtoUtils.MOD_ID
    )

    val EXAMPLE_BLOCK = blockDeferredRegister.register(
        "example_block"
    ) {
        Block(
            BlockBehaviour.Properties.of(
                Material.STONE,
                MaterialColor.TERRACOTTA_BLUE
            ).strength(2.0f, 15f)
                .requiresCorrectToolForDrops().friction(0.5f)
        )
    }

    val TESTBLOCK = blockDeferredRegister.register(
        "test_block",
    ) {
        Block(
            BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK)
        )
    }
}