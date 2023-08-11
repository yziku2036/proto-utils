package hmjn023.protoutils.core

import hmjn023.protoutils.ProtoUtils
import hmjn023.protoutils.common.item.TestItem
import net.minecraft.client.renderer.item.ItemProperties
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
class ItemInit {
    val ITEMS :DeferredRegister<Item> = DeferredRegister.create(
        ForgeRegistries.ITEMS,
        ProtoUtils.MOD_ID
    )

    val EXAMPLE_ITEM = ITEMS.register(
        "example_item",
    ){
        Item(
            Item.Properties().tab(ProtoUtils.PROTO_UTILS_TAB)
        )
    }
    val TEST_ITEM = ITEMS.register(
        "test_item"
    ){
        TestItem(
            Item.Properties().tab(ProtoUtils.PROTO_UTILS_TAB)
        )
    }

    //block items
    val EXAMPLE_BLOCK_ITEM = ITEMS.register(
        "example_block_item"
    ){
        BlockItem(
            BlockInit().EXAMPLE_BLOCK.get(),
            Item.Properties().tab(ProtoUtils.PROTO_UTILS_TAB)
        )
    }
    val TEST_BLOCK_ITEM = ITEMS.register(
        "test_block_item"
    ){
        BlockItem(
            BlockInit().TESTBLOCK.get(),
            Item.Properties().tab(ProtoUtils.PROTO_UTILS_TAB)
        )
    }
}